const AddEmployee = () => {
    const design = (
        <form>
            <fieldset>
                <legend>Enter Employee Details:</legend>
                <div>
                    <label htmlFor="txtName" className="form-label mt-4">
                        Name:
                    </label>
                    <input
                        type='text'
                        className="form-control"
                        id='txtName'
                        name='name'
                        value=''
                        placeholder='enter name'
                    />
                </div>
                <div>
                    <label htmlFor="txtSalary" className="form-label mt-4">Salary:</label>
                    <input
                        type='text'
                        className="form-control"
                        id='txSalary'
                        name='salary'
                        value=''
                        placeholder='enter salary'
                    />
                </div>
                <br />
                <div>
                    <button
                        type='submit'
                        className='btn btn-primary'>
                        Add
                    </button>
                </div>
            </fieldset>
        </form>
    )

    return design
}

export default AddEmployee