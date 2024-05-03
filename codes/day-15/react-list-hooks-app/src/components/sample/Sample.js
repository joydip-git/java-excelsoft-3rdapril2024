import React, { useState } from 'react'

const Sample = () => {
    console.log('Sample rendered')
    /*
    const stateHook = useState('No Name')
    const nameState = stateHook[0]
    const setNameState = stateHook[1]
    */
    const [nameState, setNameState] = useState('No Name')
    const [numState, setNumState] = useState(0)
    const [empState, setEmpState] = useState({ id: 1, name: 'anil', salary: 1000 })
    const nameHandler = () => {
        setNameState('Joydip')
    }
    const numHandler = () => {
        setNumState(
            (currentNum) => {
                return currentNum + 1
            }
        )
    }
    const empHandler = () => {
        setEmpState(
            (currentEmp) => {
                return {
                    ...currentEmp,
                    salary: currentEmp.salary + 100
                }
            }
        )
    }

    return (
        <>
            <div>
                Name: &nbsp;{nameState}
                <br />
                <button type='button' onClick={nameHandler}>Change Name</button>
            </div>
            <br />
            <div>
                Value: &nbsp;{numState}
                <br />
                <button type='button' onClick={numHandler}>Increase Value</button>
            </div>
            <br />
            <div>
                Emp Name: &nbsp;{empState.name ? empState.name : 'NA'}
                <br />
                Emp Salary: &nbsp;{empState.salary}
                <br />
                <button type='button' onClick={empHandler}>Update Employee</button>
            </div>
        </>
    )
}

export default Sample