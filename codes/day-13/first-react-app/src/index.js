import { createRoot } from "react-dom/client"
import { App } from "./components/app/App"

const container = document.getElementById('root')
const reactRootElement = createRoot(container)
//const appReactElement = App()
//const appReactElement = <App />
//reactRootElement.render(appReactElement)
reactRootElement.render(<App />)