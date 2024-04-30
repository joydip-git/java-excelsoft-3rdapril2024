import { header } from "../header/header";
import { footer } from "../footer/footer";

export function app() {
    const divElement = document.createElement('div')
    const headerElement = header()
    const footerElement = footer()
    divElement.append(
        headerElement,
        document.createElement('br'),
        document.createElement('br'),
        document.createElement('br'),
        document.createElement('br'),
        footerElement
    )
    return divElement
}