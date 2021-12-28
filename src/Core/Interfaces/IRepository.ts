export interface IWrite<T> {
    create(item: T):Promise<string>
    update(id: string, item: T): Promise<void>;
    delete(id: string): Promise<void>;
}


export interface IRead<T> {
    find(item: T): Promise<T[]>;
    findOne(item: T): Promise<boolean>;
}