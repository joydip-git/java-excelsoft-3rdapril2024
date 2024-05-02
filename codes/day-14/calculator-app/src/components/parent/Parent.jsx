import { Component, Fragment } from "react";
class Parent extends Component {

    state = {
        name: '',
        data: 0
    }

    nameHandler = (newName) => {
        this.setState({
            name: newName
        })
    }

    dataHandler = () => {
        this.setState(
            (cs) => {
                return { data: cs.data + 1 }
            }
        )
        // let temp = this.state.data + 1
        // this.setState({
        //     data: temp
        // })
    }
    render() {
        const design = (
            /* <Fragment> */
            <>
                <div>
                    <label htmlFor="txtName">Name:</label>
                    <input type='text' id='txtName' value={this.state.name} onChange={
                        (eventObject) => {
                            const data = eventObject.target.value
                            this.nameHandler(data)
                        }
                    } />
                </div>
                <div>
                    <span>
                        Data: &nbsp; {this.state.data}
                    </span>
                    <br />
                    <button onClick={this.dataHandler}>Increase</button>
                </div>
            </>
            /* </Fragment> */
        )
        return design;
    }
}
export default Parent