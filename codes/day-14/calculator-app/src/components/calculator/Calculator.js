import { Component } from "react"

class Calculator extends Component {

    //1. data in state
    state = {
        first: 0,
        second: 0,
        result: 0
    }

    //2. methods in the class which update the state
    updateFirst = (value) => {
        this.setState({
            first: value
        })
    }
    updateSecond = (value) => {
        this.setState({ second: value })
    }

    calculate = () => {
        this.setState(
            (currentState) => {
                return {
                    result: currentState.first + currentState.second
                }
            }
        )
    }

    //design or view
    render() {
        const design = (
            <form>
                <div>
                    <label htmlFor="txtFirst">First Value: &nbsp; </label>
                    <input type="text" id="txtFirst" value={this.state.first} onChange={
                        (eventObject) => {
                            const data = eventObject.target.value
                            if (data !== '')
                                this.updateFirst(Number(data))
                        }
                    } />
                </div>
                <div>
                    <label htmlFor="txtSecond">Second Value: &nbsp; </label>
                    <input type="text" id="txtSecond" value={this.state.second} onChange={
                        (eventObject) => {
                            const data = eventObject.target.value
                            if (data !== '')
                                this.updateSecond(Number(data))
                        }
                    } />
                </div>
                <div>
                    <button type="button" onClick={this.calculate}>Add</button>
                </div>
                <div>
                    <label htmlFor="txtResult">Result: &nbsp; </label>
                    <input type="text" id="txtResult" readOnly value={this.state.result} />
                </div>
            </form>
        )
        return design
    }
}

export default Calculator