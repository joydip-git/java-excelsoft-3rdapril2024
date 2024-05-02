import { Component } from "react";
class Sample extends Component {

    /*
    constructor(props) {
        super(props)
        this.state = {
            message: 'Welcome to Class component',
        }
    }
    */
    state = {
        message: 'Welcome to Class component',
        y: 200
        //employees: []
    }

    messageHandler = () => {
        //this.state.message = ""
        // const copy = {
        //     ...this.state
        // }
        // copy.message = "Welcome to State property"
        //this.setState(copy)
        this.setState({
            message: "Welcome to State property",
            x: 100
        })
    }
    render() {
        console.log('rendered...' + this.props.data)
        return (
            <div>
                Message: &nbsp; {this.state.message}
                <br />
                Y:&nbsp;{this.state.y}
                <br />
                X:&nbsp; {this.state.x && this.state.x}
                <br />
                <button type="button" onClick={this.messageHandler}>Change Message</button>
            </div>
        )
    }

}
export default Sample