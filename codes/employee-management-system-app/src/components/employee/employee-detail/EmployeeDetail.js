import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import employeeServiceInstance from '../../../services/employeeservice'
import Spinner from '../../common/spinner/Spinner'

const EmployeeDetail = () => {
    const routeParameters = useParams() //{id:'3',x:'',y:''}
    const id = Number(routeParameters['id'])

    const navigate = useNavigate()

    const [isRequestComplete, setIsRequestComplete] = useState(false)
    const [errorMessage, setErrorMessage] = useState('')
    const [employee, setEmployee] = useState(undefined)


    const getData = () => {
        employeeServiceInstance
            .getEmployee(id)
            .then(
                (response) => {
                    setIsRequestComplete(true)
                    setEmployee(response.data)
                    setErrorMessage('')
                }
            )
            .catch(
                (err) => {
                    setIsRequestComplete(true)
                    setEmployee(undefined)
                    setErrorMessage(err.message)
                }
            )
    }
    useEffect(
        () => {
            getData()
        },
        []
    )

    let design;
    if (!isRequestComplete) {
        design = <Spinner />
    } else if (errorMessage !== '') {
        design = <span>{errorMessage}</span>
    } else if (!employee)
        design = <span>No record</span>
    else {
        design = (
            <div>
                <span>{employee.name}</span>
                <br />
                <button className='btn btn-primary'
                    onClick={
                        () => {
                            navigate('/employees')
                        }
                    }
                >
                    Ok
                </button>
            </div>
        )
    }
    return design
}

export default EmployeeDetail