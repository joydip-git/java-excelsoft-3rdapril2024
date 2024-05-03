/*
const divide = (a, b) => {
    const p = new Promise(
        //task: executor function
        (resolveFnRef, rejectFnRef) => {
            const res = a / b
            if (res === Infinity) {
                const err = new Error('divisor should not be zero')
                //update state property of Promise to "rejected"
                rejectFnRef(err)
            }

            //update state property of Promise to "resolved/fulfilled"
            resolveFnRef(res)
        }
    )
    return p
}

const add = (a, b) => a + b

const divPromise = divide(12, 3)
divPromise
    .then(
        (data) => { console.log(data) }
    )
    .catch(
        (err) => { console.log(err) }
    )

const addRes = add(12, 3)

//console.log(divRes)
console.log(addRes)

*/
const divide = async (a, b) => {
    const res = a / b
    if (res === Infinity) {
        const err = new Error('divisor should not be zero')
        throw err
    }
    return res
}

const add = (a, b) => a + b

async function callDivide() {
    try {
        //waiting for the promise to be in "fulfilled/resolved" state
        const data = await divide(12, 3)
        console.log(data)
    } catch (err) {
        console.log(err)
    }
}
callDivide()

const addRes = add(12, 3)
console.log(addRes)