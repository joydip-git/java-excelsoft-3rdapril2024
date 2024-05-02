import { Component } from "react";
class Sample extends Component {
    state = {
        message: 'Welcome to Class component'
    }

    messageHandler = () => {
        this.setState({
            message: "Welcome to State property"
        })
    }
    render() {
        return (
            <div>
                Message: &nbsp; {this.state.message}
                <br />
                <button type="button" onClick={this.messageHandler}>Change Message</button>
            </div>
        )
    }

}
export default Sample