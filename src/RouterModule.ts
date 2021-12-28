import GutenBergApi from "./Services/Gutenberg";
import UserTodo from "./Services/UserTodoService";


export const routerModule = () => {
    const imports = [
        GutenBergApi,
        UserTodo
    ]
    return imports
}
