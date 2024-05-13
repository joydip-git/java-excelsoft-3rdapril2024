import React from 'react'

const Spinner = () => {
    return (
        <div className="d-flex justify-content-center">
            <strong role="status">Loading...</strong>
            <div className="spinner-border" role="status">
            </div>
        </div>
    )
}

export default Spinner