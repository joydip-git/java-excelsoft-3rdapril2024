import React from 'react'
import { Link } from 'react-router-dom'

const DashBoard = () => {
    return (
        <nav className="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div className="container-fluid">
                <span className="navbar-brand">EMPLOYEE MANAGEMENT SYSTEM</span>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarColor01">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item">
                            <Link to={'/home'} className='nav-link active'>
                                <span>Home</span>
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to={'/employees'} className='nav-link'>
                                <span>Employees</span>
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link to={'/employees/add'} className='nav-link'>
                                <span>Add Employee</span>
                            </Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default DashBoard