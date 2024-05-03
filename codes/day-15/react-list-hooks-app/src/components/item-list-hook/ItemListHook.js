import { useState } from "react"

const ItemListHook = () => {
    const [names, setNames] = useState(['anil', 'sunil', 'vinod'])

    const sortNamesHandler = () => {
        const copyOfNames = [...names]
        const sortedNames = copyOfNames.sort((a, b) => a.localeCompare(b))
        setNames(sortedNames)
    }

    const listItems =
        names
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
            <button type='button' onClick={sortNamesHandler}>Sort Names</button>
        </>
    )
    return design
}

export default ItemListHook
