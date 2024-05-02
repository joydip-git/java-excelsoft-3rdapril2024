import PropTypes from 'prop-types'
import { memo } from 'react'

//props={nameValue:'', nameUpdater:(newName)=>{}}
function Name(props) {
    console.log('Name (re)rendered')
    const design = (
        <div>
            <label htmlFor="txtName">Name:</label>
            <input type='text' id='txtName' value={props.nameValue} onChange={
                (eventObject) => {
                    const data = eventObject.target.value
                    props.nameUpdater(data)
                }
            } />
        </div>
    )
    return design
}
Name.propTypes = {
    nameValue: PropTypes.string.isRequired,
    nameUpdater: PropTypes.func.isRequired
}
export default memo(Name)