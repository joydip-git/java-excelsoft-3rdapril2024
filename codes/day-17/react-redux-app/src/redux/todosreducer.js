import actionTypes from "./actiontypes"

const initialTodosState = {
    todoList: []
}

const todosReducer = (currentState = initialTodosState, action) => {

    let newState

    switch (action.type) {
        case actionTypes.ADD_TODO:
            let copy = [...currentState.todoList]
            let newTodo = action.payload
            if (copy.length === 0)
                copy.push(newTodo)
            else {
                let foundIndex = copy.findIndex(t => t.id === newTodo.id)
                if (foundIndex === -1)
                    copy.push(newTodo)
                else
                    copy.splice(foundIndex, 1, newTodo)
            }
            newState = {
                ...currentState,
                todoList: copy
            }
            break;

        case actionTypes.UPDATE_TODO:
            let list = [...currentState.todoList]
            let updatedTodo = action.payload
            if (list.length === 0)
                list.push(updatedTodo)
            else {
                let index = list.findIndex(t => t.id === updatedTodo.id)
                if (index !== -1)
                    list.splice(index, 1, updatedTodo)
                else
                    list.push(updatedTodo)
            }
            newState = {
                ...currentState,
                todoList: list
            }
            break;

        default:
            newState = {
                ...currentState
            }
            break;
    }
    return newState
}

export default todosReducer