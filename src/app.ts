import express from "express";
import {routerModule} from "./RouterModule";
import axios from "axios";
import cheerio from "cheerio";
import mongoDb from "./Infrastructures/Connection/MongoDb-Connection";



const app = express()
const PORT = process.env.PORT || 4000
app.use(express.json())
app.use(routerModule())












//
// app.post('/loginToken',(req,res)=>{
//     if (req.body.user.username == user.username && req.body.user.password == user.password){
//         res.status(200).send({token:"tokenŞifre123"})
//     }else {
//         res.status(400).send("bad")
//     }
//
//
// })
//
//
// function middleware(req:any,res:any,next:any){
//     if( req.body.token== "tokensifre123"){
//         next()
//     }else {
//         return res.send({
//             token:"invalid"
//         })
//     }
// }
// app.post("/tokenCheck",middleware,(req,res)=>{
//     res.send(true)
// })



app.listen(PORT,async ()=>{
    await mongoDb()
    console.log("%s DİNLENİYOR ",PORT)
})

