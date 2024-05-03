import React, { Component } from 'react'

export default class ItemList extends Component {
    state = {
        names: ['sunil', 'vinod', 'anil']
    }
    sortNamesHandler = () => {
        const namesCopy = [...this.state.names]
        const sortedNames = namesCopy.sort(
            (a, b) => a.localeCompare(b)
        )
        this.setState({
            names: sortedNames
        })
    }
    render() {
        const listItems =
            this.state.names
                .map(
                    (name) => {
                        return <option><span>{name}</span></option>
                    }
                )
        const design = (
            <>
                <select>
                    <option selected disabled>--select--</option>
                    {listItems}
                </select>
                <br />
                <button type='button' onClick={this.sortNamesHandler}>Sort Names</button>
            </>
        )
        return design
    }
}