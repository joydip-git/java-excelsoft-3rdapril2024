import actionTypes from './actiontypes'

//action creators
export const addTodoActionCreator = (todo) => {
    return { type: actionTypes.ADD_TODO, payload: todo }
}

export const updateTodoActionCreator = (todo) => {
    return { type: actionTypes.UPDATE_TODO, payload: todo }
}

export const increaseCountActionCreator = (data) => {
    return { type: actionTypes.INCREASE, payload: data }
}

export const decreaseCountActionCreator = (data) => {
    return { type: actionTypes.DECREASE, payload: data }
}