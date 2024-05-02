import './AppHeader.css'
export function AppHeader(props) {
    // const headerMessage = 'Welcome to React JS'
    //props.message = 'new message'
    const headerDesign = (
        <div>
            <h2>
                {props.message}
            </h2>
            <br />
            <button type='button' onClick={props.showHandler}>Show</button>
        </div>
    )

    return headerDesign
}