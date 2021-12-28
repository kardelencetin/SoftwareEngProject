import mongoose from "mongoose";
import {IBook} from "./IBookModel";

export interface IUser extends mongoose.Document{
    username:string
    password:string
    readBook:[IBook]
}

