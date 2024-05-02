import PropTypes from 'prop-types'
import { memo } from 'react'

//props={dataValue:0, dataUpdater=()=>{}}
function Value(props) {
    console.log('Value (re)rendered')
    const design = (
        <div>
            <span>
                Data: &nbsp;
                {
                    /*
                        props.dataValue > 0 && 
                        props.dataValue
                    */
                    props.dataValue >= 0 ? props.dataValue : 0
                }
            </span>
            <br />
            <button type='button' onClick={props.dataUpdater}>Increase</button>
        </div >
    )
    return design
}
Value.propTypes = {
    dataValue: PropTypes.number.isRequired,
    dataUpdater: PropTypes.func.isRequired
}
export default memo(Value)