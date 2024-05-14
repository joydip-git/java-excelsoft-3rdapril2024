const { legacy_createStore, applyMiddleware } = require('redux')
const { createLogger } = require('redux-logger')

const initialState = {
    count: 0,
    //todoList: [{id:1, task:'', completed:false}]
}

const actionTypes = {
    INCREASE: 'INCREASE',
    DECREASE: 'DECREASE'
}

const countReducer = (currentState = initialState, action) => {

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

const loggerMiddleware = createLogger()
const store = legacy_createStore(
    countReducer,
    applyMiddleware(loggerMiddleware)
)

const increaseActionCreator = (data) => {
    return { type: actionTypes.INCREASE, payload: data }
}
const decreaseActionCreator = (data) => {
    return { type: actionTypes.DECREASE, payload: data }
}

//console.log(store.getState())
const increaseAction = increaseActionCreator(2)
store.dispatch(increaseAction)
//console.log(store.getState())
const decreaseAction = decreaseActionCreator(1)
store.dispatch(decreaseAction)
//console.log(store.getState())