import mongoose from "mongoose";

export interface IBook extends mongoose.Document{
    bookId:string
    bookTittle:string
    bookSubtittle:string
    bookImgURL:string
}