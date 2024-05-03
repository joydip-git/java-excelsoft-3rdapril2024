import React, { useEffect, useState } from 'react'
import { getEmployees } from "../../../services/productservice";

const EmployeeList = (props) => {
    const [employees, setEmployees] = useState([])
    const [errorMessage, setErrorMessage] = useState('')
    const [requestComplete, setRequestComplete] = useState(false)

    const getData = () => {
        getEmployees(2)
            .then(
                (httpResponse) => {
                    const records = httpResponse.data
                    setEmployees(records)
                    setErrorMessage('')
                    setRequestComplete(true)
                }
            )
            .catch(
                (err) => {
                    setEmployees(undefined)
                    setErrorMessage(err.message)
                    setRequestComplete(true)
                }
            )
    }

    useEffect(
        () => {
            getData()
        },
        []
    )

    let design
    if (!requestComplete) {
        design = <span>Loading...please wait</span>
    } else if (errorMessage !== '') {
        design = <span>{errorMessage}</span>
    } else if (!employees || employees.length === 0) {
        design = <span>No records</span>
    } else
        design = (
            <>
                {/* <div>
                    <button type='button' onClick={getData}>Load Data</button>
                </div> */}
                <br />
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            employees.map(
                                (e) => {
                                    return (
                                        <tr key={e.id}>
                                            <td>{e.id}</td>
                                            <td>{e.name}</td>
                                            <td>{e.salary}</td>
                                        </tr>
                                    )
                                }
                            )
                        }
                    </tbody>
                </table>
            </>
        )
    return design
}

export default EmployeeList