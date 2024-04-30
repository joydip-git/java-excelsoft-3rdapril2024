export function header() {
    //data
    const message = 'welcome to product management system'

    //design (view) with styles
    const divElement = document.createElement('div')
    divElement.style.backgroundColor = "Lime"
    divElement.style.borderColor = "Lime"
    divElement.style.borderWidth = "1"
    divElement.style.borderRadius = "5px";
    divElement.style.borderStyle = "solid";
    divElement.style.textAlign = "center";

    const headerElement = document.createElement('h2')
    headerElement.style.fontFamily = "consolas"

    headerElement.innerText = message
    divElement.appendChild(headerElement)

    return divElement
}