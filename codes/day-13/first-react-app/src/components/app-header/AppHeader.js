import './AppHeader.css'
export function AppHeader() {
    const headerMessage = 'Welcome to React JS'

    const headerDesign = (
        <h2>
            {headerMessage}
        </h2>
    )

    return headerDesign
}