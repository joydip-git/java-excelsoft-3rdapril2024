import React, { useEffect, useRef, useState } from 'react'
import employeeServiceInstance from '../../../services/employeeservice'
import { useNavigate } from 'react-router-dom'

const AddEmployee = () => {

    const refToName = useRef(null)
    const refToSalary = useRef(null)

    const navigate = useNavigate()
    const [disabled, setDisabled] = useState(true)
    const [nameState, setNameState] = useState({
        nameValue: '',
        validationError: ''
    })
    const [salaryState, setSalaryState] = useState({
        salaryValue: 0,
        validationError: ''
    })

    useEffect(
        () => {
            if (refToName)
                if (refToName.current)
                    refToName.current.focus()

        },
        []
    )

    const addHandler = () => {
        if (refToName)
            console.log(refToName.current)
        if (refToSalary)
            console.log(refToSalary.current)
        // eslint-disable-next-line no-restricted-globals
        if (confirm('sure to add?')) {

            employeeServiceInstance
                .addEmployee({ id: 0, name: nameState.nameValue, salary: salaryState.salaryValue })
                .then(
                    (response) => {
                        console.log(response)
                        if (response.status === 201) {
                            alert('added successfully')
                            navigate('/employees')
                        } else {
                            alert('could not add')
                        }
                    }
                )
                .catch(err => alert(err.message))
        }
    }
    return (
        <form>
            <fieldset>
                <legend>Enter Employee Details:</legend>
                <div>
                    <label htmlFor="txtName" className="form-label mt-4">Name:</label>
                    <input
                        ref={refToName}
                        type="text"
                        className="form-control"
                        id="txtName"
                        name='name'
                        placeholder="Enter Name"
                        //value={employeeState.name}
                        value={nameState.nameValue}
                        onBlur={
                            e => {
                                if (e.target.value === '') {
                                    setNameState(
                                        (oldState) => {
                                            return {
                                                ...oldState,
                                                validationError: 'please enter name'
                                            }
                                        }
                                    )
                                }
                                setDisabled(true)
                            }
                        }
                        onChange={
                            (e) => {
                                const val = e.target.value;
                                if (val !== '')
                                    // employeePropertyHandler(
                                    //     e.target.name, e.target.value)
                                    setNameState(
                                        (oldState) => {
                                            return {
                                                ...oldState,
                                                validationError: '',
                                                nameValue: val
                                            }
                                        }
                                    )
                            }
                        }
                    />
                    {
                        nameState.validationError !== '' &&
                        (
                            <div>
                                <span>
                                    {nameState.validationError}
                                </span>
                            </div>
                        )
                    }
                </div>
                <div>
                    <label htmlFor="txtSalary" className="form-label mt-4">Salary:</label>
                    <input
                        ref={refToSalary}
                        type="text"
                        className="form-control"
                        id="txtSalary"
                        name='salary'
                        placeholder="Enter Salary"
                        //value={employeeState.salary}
                        value={salaryState.salaryValue}
                        onBlur={
                            e => {
                                if (e.target.value === '') {
                                    setSalaryState(
                                        (oldState) => {
                                            return {
                                                ...oldState,
                                                validationError: 'please enter name'
                                            }
                                        }
                                    )
                                }
                            }
                        }
                        onChange={
                            (e) => {
                                const val = e.target.value;

                                if (val !== '')
                                    // employeePropertyHandler(
                                    //     e.target.name, Number(e.target.value))
                                    setSalaryState(
                                        (oldState) => {
                                            return {
                                                ...oldState,
                                                validationError: '',
                                                salaryValue: Number(val)
                                            }
                                        }
                                    )
                            }
                        }
                    />
                    {
                        salaryState.validationError !== '' &&
                        (
                            <div>
                                <span>
                                    {salaryState.validationError}
                                </span>
                            </div>
                        )
                    }
                </div>
                <br />
                <div>
                    <button type='submit' onClick={
                        (e) => {
                            e.preventDefault()
                            addHandler()
                        }
                    } className='btn btn-primary'
                        disabled={
                            nameState.validationError !== '' &&
                            salaryState.validationError !== ''
                        }>
                        Add
                    </button>
                </div>
            </fieldset>
        </form >
    )
}

export default AddEmployee

// const [employeeState, setEmployeeState] = useState({
//     id: 0,
//     name: '',
//     salary: 0
// })
/*
const employeePropertyHandler = (propName, propValue) => {
    setEmployeeState(
        (oldState) => {
            return {
                ...oldState,
                [propName]: propValue
            }
        }
    )
}
*/