export function footer() {
    const divElement = document.createElement('div')
    divElement.innerHTML = `<h3>Copyright &copy;, Excelsoft, 2024<h3>`
    divElement.style.textAlign = 'center'
    divElement.style.backgroundColor = 'burlywood'
    divElement.style.fontFamily = 'consolas'

    return divElement
}