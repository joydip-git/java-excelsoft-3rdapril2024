import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import emloyeeServiceInstance from '../../../services/employeeservice'
import Spinner from '../../common/spinner/Spinner'
import employeeServiceInstance from '../../../services/employeeservice'

const UpdateEmployee = () => {
    const navigate = useNavigate()
    const params = useParams()
    // const [product, setProduct] = useState({
    //     id: 0,
    //     name: '',
    //     salary: 0,
    // })
    const [isRequestComplete, setIsRequestComplete] = useState(false)
    const [errorMessage, setErrorMessage] = useState('')

    const [id, setId] = useState({
        type: 'text',
        name: 'id',
        id: 'txtId',
        value: '',
        isReadonly: true,
        labelText: 'Id:'
    })
    const [name, setName] = useState({
        type: 'text',
        name: 'name',
        id: 'txtName',
        value: '',
        isReadonly: false,
        labelText: 'Name:'
    })
    const [salary, setSalary] = useState({
        type: 'text',
        name: 'salary',
        id: 'txtSalary',
        value: '',
        isReadonly: false,
        labelText: 'Salary:'
    })

    const [errors, setErrors] = useState({})
    const pid = Number(params['id'])

    const getProduct = () => {
        emloyeeServiceInstance
            .getEmployee(pid)
            .then(
                (response) => {
                    //setProduct(response.data)
                    setId(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: response.data.id

                            }
                        }
                    )
                    setName(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: response.data.name

                            }
                        }
                    )
                    setSalary(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: response.data.salary

                            }
                        }
                    )
                    setErrorMessage('')
                    setIsRequestComplete(true)
                }
            )
            .catch(
                (err) => {
                    setId(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: undefined

                            }
                        }
                    )
                    setName(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: undefined

                            }
                        }
                    )
                    setSalary(
                        (oldState) => {
                            return {
                                ...oldState,
                                value: undefined

                            }
                        }
                    )
                    setErrorMessage(err.message)
                    setIsRequestComplete(true)
                }
            )
    }
    /*
    const productHandler = (eventObj, propName) => {
        const { value } = eventObj.target
        if (value.trim()) {
            setProduct(
                (oldProduct) => {
                    if (oldProduct) {
                        return {
                            ...oldProduct,
                            [propName]: value
                        }
                    } else {
                        return {
                            id: 0,
                            name: '',
                            salary: 0,
                            [propName]: value
                        }
                    }
                }
            )
        }
    }
    */
    const nameHandler = (eventObj) => {
        const { value } = eventObj.target
        setName(
            (oldState) => {
                return {
                    ...oldState,
                    value: value
                }
            }
        )
    }

    const salaryHandler = (eventObj) => {
        const { value } = eventObj.target

        setSalary(
            (oldState) => {
                return {
                    ...oldState,
                    value: value
                }
            }
        )

    }

    const validateForm = () => {
        const validationErrors = {}

        if (!name.value.trim())
            validationErrors.name = 'name is required'

        if (!salary.value.trim())
            validationErrors.salary = 'salary is required'

        return validationErrors
    }
    const submitProduct = (e) => {
        e.preventDefault()
        const errors = validateForm()
        setErrors(errors)
        if (Object.keys(errors).length === 0) {
            employeeServiceInstance
                .updateEmployee(id, { id: id.value, name: name.value, salary: salary.value })
                .then(
                    (response) => {
                        if (response.status === 200) {
                            alert('updated successfully')
                            navigate('/employees')
                        } else {
                            alert('could not update')
                        }
                    }
                )
                .catch(
                    err => alert(err.message)
                )
        }
    }
    useEffect(
        () => {
            getProduct()
        },
        []
    )

    let design
    if (!isRequestComplete) {
        design = <Spinner />
    } else if (errorMessage.trim()) {
        design = <span>{errorMessage}</span>
    } else if (!id.value && !name.value && !salary.value) {
        design = <span>No record</span>
    } else {
        design = (
            <form onSubmit={submitProduct}>
                <fieldset>
                    <legend>Enter Employee Details:</legend>
                    <div>
                        <label
                            htmlFor={id.id}
                            className="form-label mt-4">
                            {id.labelText}
                        </label>
                        <input
                            type={id.type}
                            className="form-control"
                            id={id.id}
                            name={id.name}
                            value={id.value}
                            readOnly={id.isReadonly}
                        />
                    </div>
                    <div>
                        <label htmlFor={name.id} className="form-label mt-4">
                            {name.labelText}
                        </label>
                        <input
                            type={name.type}
                            className="form-control"
                            id={name.id}
                            name={name.name}
                            value={name.value}
                            placeholder='enter name'
                            onChange={nameHandler}
                            readOnly={name.isReadonly}
                        />
                    </div>
                    {
                        errors.name &&
                        (
                            <span>{errors.name}</span>
                        )
                    }
                    <div>
                        <label htmlFor={salary.id} className="form-label mt-4">
                            {salary.labelText}
                        </label>
                        <input
                            type={salary.type}
                            className="form-control"
                            id={salary.id}
                            name={salary.name}
                            value={salary.value}
                            placeholder='enter salary'
                            onChange={salaryHandler}
                            readOnly={salary.isReadonly}
                        />
                    </div>
                    {
                        errors.salary &&
                        (
                            <span>{errors.salary}</span>
                        )
                    }
                    <br />
                    <div>
                        <button
                            type='submit'
                            className='btn btn-primary'>
                            Update
                        </button>
                    </div>
                </fieldset>
            </form >
        )
    }
    return design
}

export default UpdateEmployee