import React, { useState } from 'react'

const CalculatorWithHook = () => {
    // const [first, setFirst] = useState(0)
    // const [second, setSecond] = useState(0)
    // const [result, setResult] = useState(0)

    const [calcState, setCalcState] = useState({ first: 0, second: 0, result: 0 })

    return (
        <form>
            <div>
                <label htmlFor='txtFirst'>First:&nbsp;</label>
                <input
                    type='text'
                    id='txtFirst'
                    value={calcState.first}
                    onChange={
                        (e) => {
                            const data = e.target.value
                            if (data !== '') {
                                setCalcState(
                                    (currentStateCopy) => {
                                        return {
                                            ...currentStateCopy,
                                            first: Number(data)
                                        }
                                    }
                                )
                            }
                        }
                    }
                />
            </div>
            <div>
                <label htmlFor='txtSecond'>Second:&nbsp;</label>
                <input
                    type='text'
                    id='txtSecond'
                    value={calcState.second}
                    onChange={
                        (e) => {
                            const data = e.target.value
                            if (data !== '') {
                                setCalcState(
                                    (currentStateCopy) => {
                                        return {
                                            ...currentStateCopy,
                                            second: Number(data)
                                        }
                                    }
                                )
                            }
                        }
                    }
                />
            </div>
            <div>
                <button
                    type='button'
                    onClick={
                        () => {
                            setCalcState(
                                (currentStateCopy) => {
                                    return {
                                        ...currentStateCopy,
                                        result: currentStateCopy.first + currentStateCopy.second
                                    }
                                }
                            )
                        }
                    }
                >
                    Add
                </button>
            </div>
            <div>
                <label htmlFor='txtResult'>Result:&nbsp;</label>
                <input type='text' id='txtResult' value={calcState.result} readOnly />
            </div>
        </form>
    )
}

export default CalculatorWithHook