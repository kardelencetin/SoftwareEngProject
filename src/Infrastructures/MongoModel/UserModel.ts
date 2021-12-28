import mongoDb, {Schema} from "mongoose";
import { IUser} from "../../Core/Model/IUserModel";
import {BookModel, BookSchema} from "./BookModel";



const UserSchema = new Schema<IUser>({
    username:String,
    password:String,
    readBook: [BookSchema]

})
const UserModel = mongoDb.model<IUser>("USER",UserSchema,"UserCollection")
export default UserModel


