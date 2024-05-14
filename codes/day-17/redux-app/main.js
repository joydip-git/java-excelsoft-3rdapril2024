const { legacy_createStore, applyMiddleware } = require('redux')
const { createLogger } = require('redux-logger')

const initialState = {
    todoList: []
}
const actionTypes = {
    ADD_TODO: 'ADD_TODO',
    UPDATE_TODO: 'UPDATE_TODO'
}

const addActionCreator = (todo) => {
    return { type: actionTypes.ADD_TODO, payload: todo }
}
const updateActionCreator = (todo) => {
    return { type: actionTypes.UPDATE_TODO, payload: todo }
}

const todosReducer = (currentState = initialState, action) => {

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

const loggerMiddleware = createLogger()
const store = legacy_createStore(
    todosReducer,
    applyMiddleware(loggerMiddleware)
)

const addReduxBasicTodoAction = addActionCreator({ id: 1, task: 'teach redux basics', completed: false })
store.dispatch(addReduxBasicTodoAction)

const addFormsTodoAction = addActionCreator({ id: 2, task: 'teach forms', completed: false })
store.dispatch(addFormsTodoAction)

const updateReduxBasicTodoAction = updateActionCreator({ id: 1, task: 'teach redux basics', completed: true })
store.dispatch(updateReduxBasicTodoAction)