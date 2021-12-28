import mongoose from "mongoose";
import {IRead, IWrite} from "../../Core/Interfaces/IRepository";





export default abstract class Repository<T> implements IWrite<T>,IRead<T>{

    constructor(
        public model:mongoose.Model<T>
    ) {
    }


    async create(item: T):Promise<string>{
        return new Promise((resolve, reject)=>{
            this.model.create(item,(err,res)=>{
                if(err){
                    reject(err)
                }else{
                    resolve("Kayıt Başarılı")
                }
            })
        })
    }

    async delete(id: string): Promise<void> {
        return Promise.resolve(undefined);
    }

    async find(item: T): Promise<T[]> {

        return Promise.resolve([]);
    }

    async findOne(item: T): Promise<boolean> {
        // @ts-ignore
        const finded = await this.model.findOne({username:item.username})
        if (finded==null){
            return Promise.resolve(false);
        }else{
            return Promise.resolve(true);
        }

    }

    update(id: string, item: T): Promise<void> {

        return Promise.resolve(undefined);
    }


}

