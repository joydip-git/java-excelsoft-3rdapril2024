import { Component, Fragment } from "react";
import Name from "../name/Name";
import Value from "../value/Value";
class Parent extends Component {

    state = {
        name: '',
        data: -1
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
        console.log('Parent (re)rendered')
        const design = (
            /* <Fragment> */
            <>
                <Name nameValue={this.state.name} nameUpdater={this.nameHandler} />
                <br />
                <Value dataValue={this.state.data} dataUpdater={this.dataHandler} />
            </>
            /* </Fragment> */
        )
        return design;
    }
}
export default Parent