import mongoDb, {Schema} from "mongoose";
import {IUser} from "../../Core/Model/IUserModel";
import {IBook} from "../../Core/Model/IBookModel"


const BookSchema = new Schema<IBook>({
    bookId:String,
    bookTittle:String,
    bookSubtittle:String,
    bookImgURL:String
})
const BookModel = mongoDb.model<IBook>("Book",BookSchema,"BookCollection")
export {BookModel,BookSchema}