import {Router} from "express";
import UserController from "../Controller/UserController";
import UserModel from "../Infrastructures/MongoModel/UserModel";
import UserRepo from "../Infrastructures/Repository/UserRepo";
const UserTodo = Router()


const userRepo = new UserRepo(UserModel)
const userController = new UserController(userRepo)
UserTodo.post('/CreateUser',(req,res)=>{
    userController.createUser(req).then((result)=>{
        res.send(result)
    })
})
UserTodo.post('/AddBook',(req,res)=>{
    userController.addBook(req).then((result)=>{
        res.send("kitap eklendi")
    })
})
export default UserTodo