

import {Request,Response} from "express";

import UserRepo from "../../Infrastructures/Repository/UserRepo";
import UserModel from "../../Infrastructures/MongoModel/UserModel";
import {BookSchema} from "../../Infrastructures/MongoModel/BookModel";


export default async (req:Request,userRepository:UserRepo) => {



    const CreateUser = new UserModel({
        username:req.body.username,
        password:req.body.password,
        readBook:req.body.book

    })
    const find = await userRepository.findOne(CreateUser)
    if(find == false){
        await userRepository.create(CreateUser)
    }

}