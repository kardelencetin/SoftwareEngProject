import redis from "redis";

const client = redis.createClient()


client.on("error", function(error) {
    if (error){

        console.log(error)
    }
    console.log("başarılı")
});


client.get("user",(err,message)=>{
    console.log(message)
})
export default client