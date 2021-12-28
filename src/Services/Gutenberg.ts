import {Router} from "express";
import axios from "axios";
import cheerio from "cheerio";
import RedisClient from "../Infrastructures/Connection/Redis-Connection";

const Gutenberg = Router()


Gutenberg.get('/popularBooks',(req,res)=>{
    const url = 'https://www.gutenberg.org/'
    const data:any = []
    axios.get(url).then((response)=>{
        const $ = cheerio.load(response.data)
        $("div[class='lib latest no-select']").find('a').each((index,element)=>{
            console.log(`element ${element} index ${index}`)
            const bookId = $(element).attr('href')
            const title = $(element).attr('title')
            const authors = $(element).attr('authors')
            const image = `https://www.gutenberg.org${$(element).find('div > div > img').attr('src')}`
            data[index] = {bookId,title,authors,image}
        })
        res.send(data)
    })

})
Gutenberg.get('/browse/titles/:id',(req,res)=>{
    const url = "https://www.gutenberg.org/browse/titles/"+req.params.id ?? "a"

    const id = req.params.id
    RedisClient.hgetall(id, (err,recipe)=>{
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
                    RedisClient.hmset(id,{ data: JSON.stringify(data) } ,(err,res)=>{
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
Gutenberg.get('/books/search/:query',(req,res)=>{
    const whitespace = req.params.query ?? "";
    const data:any = []
    axios.get('https://www.gutenberg.org/ebooks/search/',{
        params:{
            query: whitespace
        }
    }).then(response=>{
        const $ = cheerio.load(response.data);
        $('.booklink').each((index,element)=>{
            // const newStr:string[] = str.split("/", 3)
            // console.log(newStr[newStr.length-1])

            const newStr:string | undefined = $(element).find('.link').attr('href')
            // @ts-ignore
            const newArr:string[] | undefined  = newStr.split("/", 3)
            const link = newArr[newArr.length-1]
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


Gutenberg.get('/ebooks/:id',(req,res)=>{
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

Gutenberg.get("/getBookContent/BookId/:bookId",(req,res)=>{
    const bookId = req.params.bookId
    // files/67015/67015-h/67015-h.htm
    // /files/67012/67012-h/67012-h.htm
    // const url = `https://www.gutenberg.org/cache/epub/${bookId}/pg${bookId}-images.html.utf8`
    const url = `https://www.gutenberg.org/files/${bookId}/${bookId}-h/${bookId}-h.htm`
    axios.get(url).then((result)=>{
        const $ = cheerio.load(result.data)
        $('table').find('tbody>tr').each((i,e)=>{
            const a = $(e)
        })
    })
})

export default Gutenberg