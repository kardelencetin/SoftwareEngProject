import express from "express";
import axios from "axios";
import cheerio from "cheerio";
import redis from "redis";

const client = redis.createClient()
const app = express()
const PORT = process.env.PORT || 4000
app.use(express.json())

client.on("error", function(error) {
    if (error){

        console.log(error)
    }
    console.log("başarılı")
});
// client.set("user","tugrul",(err,message)=>{
//     if (err){console.log(err)}
//     console.log(message)
// })

client.get("user",(err,message)=>{
    console.log(message)
})


app.get('/browse/titles/:id',(req,res)=>{
    const url = "https://www.gutenberg.org/browse/titles/"+req.params.id ?? "a"

    const id = req.params.id
    client.hgetall(id, (err,recipe)=>{
        if(recipe){
            return res.status(200).send(JSON.parse(recipe["data"]))
        }else { // When the data is not found in the cache then we can make request to the server


            axios.get(url)
                .then(function (response) {
                    // handle success
                    const $ = cheerio.load(response.data);

                    const data:any = []
                    $('.pgdbbytitle').find('h2').each((index,element)=>{
                        const title = $(element).text()
                        const link = $(element).find('a').attr('href')
                        const author = $(element).next().text()
                        data[index] = {title,author,link}

                    })
                    client.hmset(id,{ data: JSON.stringify(data) } ,(err,res)=>{
                        if(err){
                            console.log(err)
                        }else{
                            console.log("başarılı")
                        }

                    })
                    res.send({data:data})
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
        }
    })


})

app.get('/books/search/:query',(req,res)=>{
    const whitespace = req.params.query ?? "";
    const data:any = []
    axios.get('https://www.gutenberg.org/ebooks/search/',{
        params:{
            query: whitespace
        }
    }).then(response=>{
        const $ = cheerio.load(response.data);
        $('.booklink').each((index,element)=>{
            const link = $(element).find('.link').attr('href')
            const image ="https://www.gutenberg.org" + $(element).find('.cover-thumb').attr('src')
            const title = $(element).children('a').find('.title').text()
            const subtitle = $(element).children('a').find('.subtitle').text()
            const extra = $(element).children('a').find('.extra').text()
            data[index] = {title,subtitle,extra,link,image}

        })

        res.send(data)

    }).catch(err=>{
        // handle error
        console.log(err);
    })
})

app.get('/ebooks/:id',(req,res)=>{
    const url = 'https://www.gutenberg.org/ebooks/'+req.params.id ?? ""
    axios.get(url).then(response=>{

        const $ = cheerio.load(response.data)
        let scores = new Map<string, string>();
       $('.bibrec').find('tbody').find('tr').each((index,element)=>{

           if (index != 3 && (index <6 || index >11)){
               const a = $(element).find('th').text()
               const b = $(element).find('td').text()
               scores.set(a,b)
           }

       })
        const result = Object.fromEntries(scores);
        res.send(result)


    }).catch(err=>{
        console.log(err)
    })
})


app.listen(PORT,()=>{
    console.log("%s DİNLENİYOR ",PORT)
})

