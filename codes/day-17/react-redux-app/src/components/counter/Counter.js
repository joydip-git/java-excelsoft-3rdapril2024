import React, { useState } from 'react'
import { useSelector, useDispatch } from "react-redux";
import { decreaseCountActionCreator, increaseCountActionCreator } from "../../redux/actioncreators";

const Counter = () => {
    const [choiceState, setChoiecState] = useState(0)

    const dispatch = useDispatch()
    const { count } = useSelector(
        (stateMap) => stateMap.countState
    )
    const countHandler = (value) => {
        switch (choiceState) {
            case 1:
                const increaseAction = increaseCountActionCreator(value)
                dispatch(increaseAction)
                break;

            case 2:
                const decreaseAction = decreaseCountActionCreator(value)
                dispatch(decreaseAction)
                break;

            default:
                break;
        }
    }
    const design = (
        <div>
            <div>
                <label htmlFor='radioIncrease'>
                    Increase: &nbsp;
                </label>
                <input type='radio' id='radioIncrease' name='options' onChange={() => setChoiecState(1)} />
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <label htmlFor='radioDecrease'>
                    Decrease: &nbsp;
                </label>
                <input type='radio' id='radioDecrease' name='options' onChange={() => setChoiecState(2)} />
            </div>
            <span>Count Value: &nbsp;{count}</span>
            <br />
            <div>
                <label htmlFor='txtCount'>
                    Increase By: &nbsp;
                </label>
                <input
                    type='text'
                    id='txtCount'
                    onChange={
                        (e) => {
                            if (e.target.value.trim()) {
                                countHandler(
                                    Number(e.target.value)
                                )
                            }
                        }
                    } />
            </div>
            {/* <button
                onClick={increaseHandler}
                type='button'>
                Increase
            </button> */}
        </div>
    )
    return design
}

export default Counter