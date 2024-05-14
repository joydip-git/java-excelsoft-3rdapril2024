const { legacy_createStore, applyMiddleware, combineReducers } = require('redux')
const { createLogger } = require('redux-logger')

const initialTodosState = {
    todoList: []
}
const initialCountState = {
    count: 0
}

const actionTypes = {
    ADD_TODO: 'ADD_TODO',
    UPDATE_TODO: 'UPDATE_TODO',
    INCREASE: 'INCREASE',
    DECREASE: 'DECREASE'
}

const addTodoActionCreator = (todo) => {
    return { type: actionTypes.ADD_TODO, payload: todo }
}
const updateTodoActionCreator = (todo) => {
    return { type: actionTypes.UPDATE_TODO, payload: todo }
}
const increaseCountActionCreator = (data) => {
    return { type: actionTypes.INCREASE, payload: data }
}
const decreaseCountActionCreator = (data) => {
    return { type: actionTypes.DECREASE, payload: data }
}

const countReducer = (currentState = initialCountState, action) => {

    let newState

    switch (action.type) {
        case actionTypes.INCREASE:
            newState = {
                ...currentState,
                count: currentState.count + action.payload
            }
            break;

        case actionTypes.DECREASE:
            newState = {
                ...currentState,
                count: currentState.count - action.payload
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

const loggerMiddleware = createLogger()
const reducerMap = combineReducers({
    countState: countReducer,
    todosState: todosReducer
})
const store = legacy_createStore(
    reducerMap,
    applyMiddleware(loggerMiddleware)
)
export default store
/*
const addReduxBasicTodoAction = addTodoActionCreator({ id: 1, task: 'teach redux basics', completed: false })
store.dispatch(addReduxBasicTodoAction)

const addFormsTodoAction = addTodoActionCreator({ id: 2, task: 'teach forms', completed: false })
store.dispatch(addFormsTodoAction)

const updateReduxBasicTodoAction = updateTodoActionCreator({ id: 1, task: 'teach redux basics', completed: true })
store.dispatch(updateReduxBasicTodoAction)

const increaseAction = increaseCountActionCreator(2)
store.dispatch(increaseAction)
const decreaseAction = decreaseCountActionCreator(1)
store.dispatch(decreaseAction)
*/