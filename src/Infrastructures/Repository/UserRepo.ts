import Repository from "./BaseRepo";
import {IUser} from "../../Core/Model/IUserModel";
import {update} from "cheerio/lib/parse";
import {IBook} from "../../Core/Model/IBookModel";


export default class UserRepo extends Repository<IUser>{

    async AddBook(item: String,book:IBook){
        this.model.updateOne({username:item},{ $push: { readBook: book }}).catch(err=>{
            console.log(err)
        })

// is sent as
//         Model.update(query, { $set: { name: 'jason bourne' }}, options, function(err, res));
    }
}