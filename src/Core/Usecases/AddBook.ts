


import {Request,Response} from "express";

import UserRepo from "../../Infrastructures/Repository/UserRepo";
import UserModel from "../../Infrastructures/MongoModel/UserModel";
import {BookModel, BookSchema} from "../../Infrastructures/MongoModel/BookModel";


export default async (req:Request,userRepository:UserRepo) => {



    const book = new BookModel({
        bookId:req.body.bookId,
        bookTittle:req.body.bookTittle,
        bookSubtittle:req.body.bookSubtittle,
        bookImgURL:req.body.bookImgURL

    })
    // bookId:string
    // bookTittle:string
    // bookSubtittle:string
    // bookImgURL:string
    await userRepository.AddBook(req.body.username,book)

}