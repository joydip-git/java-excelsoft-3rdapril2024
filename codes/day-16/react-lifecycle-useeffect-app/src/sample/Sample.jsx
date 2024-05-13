import React, { Component } from 'react'
import PropType from 'prop-types'
import axios from 'axios'

class Sample extends Component {
    static propType = {
        message: PropType.string.isRequired
    }
    //1st cycle ONLY
    constructor(props) {
        super(props)
        // this.state = {
        //     num: 0
        // }
        console.log("Sample created...")
        console.log("Sample rceived property message: " + this.props.message)
    }
    state = {
        num: 0,
        posts: [],
        isRequestComplete: false,
        errorMessage: '',
        selectedId: 0,
        post: undefined,
        isFetchRequestComplete: false
    }
    //2nd cycle onwards, every time
    shouldComponentUpdate(currentProps, currentState) {
        console.log("Sample shouldComponentUpdate..")
        console.log("old message: " + this.props.message)
        console.log("current message: " + currentProps.message)
        console.log("old state: " + this.state.num)
        console.log("current state: " + currentState.num)
        if (this.props.message === currentProps.message && currentState.num === this.state.num && this.state.posts.length === currentState.posts.length && (!this.state.post && this.state.post === currentState.post) && this.state.selectedId === currentState.selectedId)
            return false

        return true
    }
    //1st cycle and every other cycle when SCU returns true
    render() {
        console.log("Sample rendered...")
        console.log(this.props)
        console.log(this.state)

        let design;
        let postDesign;

        if (!this.state.isFetchRequestComplete) {
            postDesign = <span>Loading...please wait...</span>
        } else if (this.state.errorMessage !== '') {
            postDesign = <span>{this.state.errorMessage}</span>
        } else if (!this.state.post) {
            postDesign = <span> could not get data</span>
        } else {
            postDesign = (
                <div>
                    <span>Posted By: &nbsp;{this.state.post.userId}</span>
                    <br />
                    <span>Post Id: &nbsp;{this.state.post.id}</span>
                    <br />
                    <span>Title: &nbsp;{this.state.post.title}</span>
                    <br />
                    <span>Body: &nbsp;{this.state.post.body}</span>
                </div>
            )
        }

        if (!this.state.isRequestComplete) {
            design = <span>Loading...please wait...</span>
        } else if (this.state.errorMessage !== '') {
            design = <span>{this.state.errorMessage}</span>
        } else if (this.state.posts.length === 0) {
            design = <span> could not get data</span>
        } else {
            design = (
                <table>
                    <thead>
                        <tr>
                            <th>Post Title</th>
                            <th>Post Body</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.posts.map(
                                (p) => (
                                    <tr key={p.id} onClick={
                                        () => {
                                            this.setState({
                                                selectedId: p.id
                                            })
                                        }
                                    }>
                                        <td>{p.title}</td>
                                        <td>{p.body}</td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            )
        }
        return (
            <div>
                <br />
                <span> Message: {this.props.message}</span>
                <br />
                <span>Value: &nbsp;{this.state.num}</span>
                <br />
                <button type='button' onClick={
                    () => {
                        this.setState(
                            (oldstate) => {
                                return {
                                    num: oldstate.num + 1
                                }
                            }
                        )
                    }
                }   >
                    Increase
                </button>
                <br />
                <br />
                {design}
                <br />
                <br />
                {
                    this.state.selectedId > 0 &&
                    (
                        <div>Selected Post detail:<br />
                            {postDesign}
                        </div>
                    )
                }
            </div>
        )
    }
    //2nd cycle and every other cycle when SCU returns true
    componentDidUpdate(oldProps, oldState) {
        if (!this.state.post || (oldState.post && (this.state.post.id === oldState.post.id))) {
            console.log("Sample updated....")
            axios.get('https://jsonplaceholder.typicode.com/posts/' + this.state.selectedId)
                .then(
                    (response) => {
                        this.setState({
                            post: response.data,
                            errorMessage: '',
                            isFetchRequestComplete: true
                        })
                    }
                )
                .catch(
                    (err) => {
                        this.setState({
                            post: undefined,
                            errorMessage: err.message,
                            isFetchRequestComplete: true
                        })
                    }
                )
        }
    }
    //1st cycle ONLY
    //use it for fetching data from RESTful API/ file/sending request through WebSocket, i.e. any side-effect causing code, but ONLY ONE TIME
    componentDidMount() {
        console.log("Sample mounted...")
        axios
            .get('https://jsonplaceholder.typicode.com/posts')
            .then(
                (response) => {
                    this.setState({
                        posts: response.data.slice(0, 3),
                        errorMessage: '',
                        isRequestComplete: true
                    })
                }
            )
            .catch(
                (err) => {
                    this.setState({
                        posts: [],
                        errorMessage: err.message,
                        isRequestComplete: true
                    })
                }
            )
    }
    //destruction/unmounted ONLY
    //clean-up resource
    componentWillUnmount() {
        console.log("Sample destroyed...")
    }
}
export default Sample
