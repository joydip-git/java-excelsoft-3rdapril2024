import React, { Component, useEffect, useState } from 'react'
import EmployeeCard from '../employee-card/EmployeeCard';
import Spinner from '../../common/spinner/Spinner';
import employeeServiceInstance from '.././../../services/employeeservice'

/*
export class EmployeeList extends Component {

    state = {
        isRequestComplete: false,
        employees: [],
        errorMessage: ''
    }

    render() {
        const { isRequestComplete, employees, errorMessage } = this.state

        let design;
        if (!isRequestComplete) {
            design = <Spinner />
        } else if (errorMessage !== '') {
            design = <span>{errorMessage}</span>
        } else if (employees.length === 0)
            design = <span>No records</span>
        else {
            design = employees.map(
                (e) => <EmployeeCard employee={e} key={e.id} />
            )
        }
        return design
    }
    componentDidMount() {
        setTimeout(
            () => {
                employeeServiceInstance
                    .getEmployees(1)
                    .then(
                        (response) => {
                            this.setState({
                                isRequestComplete: true,
                                errorMessage: '',
                                employees: response.data
                            })
                        }
                    )
                    .catch(
                        (err) => {
                            this.setState({
                                isRequestComplete: true,
                                errorMessage: err.message,
                                employees: []
                            })
                        }
                    )
            }, 2000
        )
    }
}

export default EmployeeList
*/

const EmployeeList = () => {
    const [employeeState, setEmployeeState] = useState({
        isRequestComplete: false,
        employees: [],
        errorMessage: ''
    })
    const { isRequestComplete, employees, errorMessage } = employeeState

    const getData = () => {
        setTimeout(
            () => {
                employeeServiceInstance
                    .getEmployees(1)
                    .then(
                        (response) => {
                            setEmployeeState({
                                isRequestComplete: true,
                                errorMessage: '',
                                employees: response.data
                            })
                        }
                    )
                    .catch(
                        (err) => {
                            setEmployeeState({
                                isRequestComplete: true,
                                errorMessage: err.message,
                                employees: []
                            })
                        }
                    )
            }, 2000
        )
    }

    useEffect(
        () => {
            getData()
        },
        []
    )
    const deleteHandler = (id) => {
        employeeServiceInstance
            .deleteEmployee(id)
            .then(
                (response) => {
                    if (response.data > 0) {
                        const foundIndex = employees.findIndex(e => e.id === id)
                        const copy = [...employees]
                        copy.splice(foundIndex, 1)
                        setEmployeeState(
                            (oldState) => {
                                return {
                                    ...oldState,
                                    employees: copy
                                }
                            }
                        )
                        //getData()
                    }
                }
            )
            .catch(
                err => {
                    alert('could not delete record: ' + err.message)
                    // setEmployeeState({
                    //     errorMessage: err.message
                    // })
                }
            )
    }

    let design;
    if (!isRequestComplete) {
        design = <Spinner />
    } else if (errorMessage !== '') {
        design = <span>{errorMessage}</span>
    } else if (employees.length === 0)
        design = <span>No records</span>
    else {
        design = employees.map(
            e => <EmployeeCard employee={e} key={e.id} deleteHandlerFn={deleteHandler} />
        )
    }


    return design
}

export default EmployeeList
