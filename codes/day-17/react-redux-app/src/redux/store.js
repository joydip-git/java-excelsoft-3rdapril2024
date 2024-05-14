import { legacy_createStore, applyMiddleware, combineReducers } from "redux";
import { createLogger } from "redux-logger";
import countReducer from './countreducer'
import todosReducer from './todosreducer'

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
