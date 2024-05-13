import React from 'react'
import PropTypes from 'prop-types'
import { Link } from "react-router-dom";

const EmployeeCard = props => {
    const { employee, deleteHandlerFn } = props

    return (
        <div style={{ display: 'flex' }}>
            <div className="card" style={{ width: "18rem" }}>
                <div className="card-body">
                    <h5 className="card-title">
                        Details of
                        <Link to={`/employees/view/${employee.id}`}>
                            <span>{employee.name}</span>
                        </Link>
                    </h5>

                    <p className="card-text">
                        <span> Id: {employee.id}</span>
                        &nbsp;&nbsp;
                        <span> Salary: {employee.salary}</span>
                    </p>
                    <button type='button' className='btn btn-danger' onClick={
                        () => { deleteHandlerFn(employee.id) }
                    }>
                        Delete
                    </button>
                </div>
            </div>
        </div>
    )
}

EmployeeCard.propTypes = {
    employee: PropTypes.object.isRequired,
    deleteHandlerFn: PropTypes.func.isRequired
}

export default EmployeeCard