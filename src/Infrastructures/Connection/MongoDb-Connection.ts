
import mongoose from 'mongoose';


export default  function dbConnection(){
    mongoose.connect("mongodb://root:example@localhost:27019/")
        .catch(err=>console.log(`hata:${err}`))

    mongoose.connection
        .once('open',()=>console.log("bağlantı başarılı"))
        .on("error",(error)=>{
            console.log(error);
        })


}
