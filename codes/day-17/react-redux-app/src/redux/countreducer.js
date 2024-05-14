import actionTypes from "./actiontypes";

const initialCountState = {
    count: 0
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

export default countReducer