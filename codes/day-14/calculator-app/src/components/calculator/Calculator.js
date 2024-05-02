function Calculator() {

    //code
    //1. data
    let first = 0
    let second = 0
    let result = 0

    //2. methods
    const updateFirst = (value) => {
        console.log(value)
        first = value
        console.log(first)
    }
    const updateSecond = (value) => {
        console.log(value)
        second = value
        console.log(second)
    }

    const calculate = () => {
        result = Number(first) + Number(second)
        console.log(result)
    }

    //design or view
    const design = (
        <form>
            <div>
                <label htmlFor="txtFirst">First Value: &nbsp; </label>
                <input type="text" id="txtFirst" value={first} onChange={
                    (eventObject) => {
                        const data = eventObject.target.value
                        updateFirst(data)
                    }
                } />
            </div>
            <div>
                <label htmlFor="txtSecond">Second Value: &nbsp; </label>
                <input type="text" id="txtSecond" value={second} onChange={
                    (eventObject) => {
                        const data = eventObject.target.value
                        updateSecond(data)
                    }
                } />
            </div>
            <div>
                <button type="button" onClick={calculate}>Add</button>
            </div>
            <div>
                <label htmlFor="txtResult">Result: &nbsp; </label>
                <input type="text" id="txtResult" readOnly value={result} />
            </div>
        </form>
    )
    return design
}

export default Calculator