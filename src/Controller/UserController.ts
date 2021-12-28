import UserRepo from "../Infrastructures/Repository/UserRepo";
import {Request} from "express";
import CreateUserUsecase from "../Core/Usecases/CreateUserUsecase";
import addBook from "../Core/Usecases/AddBook";




export default class UserController {
    constructor(
        private readonly userRepo: UserRepo
    ) {
    }

    async createUser(req: Request) {
        const createInfo = await CreateUserUsecase(req, this.userRepo)
        return createInfo
    }

    async addBook(req: Request){
        await addBook(req, this.userRepo)
    }
}