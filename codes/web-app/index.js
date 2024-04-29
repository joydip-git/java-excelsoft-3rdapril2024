async function getData() {
    try {
        const response = await fetch('http://localhost:8001/employees')
        const records = await response.json()
        const tbodyObj = document.getElementById('tblBody')

        for (let i = 0; i < records.length; i++) {
            const employee = records[i]

            const tdId = document.createElement('td')
            const tdName = document.createElement('td')
            const tdSalary = document.createElement('td')

            tdId.innerText = employee.id
            tdName.innerText = employee.name
            tdSalary.innerText = employee.salary

            const row = document.createElement('tr')
            row.append(tdId, tdName, tdSalary)

            tbodyObj.appendChild(row)
        }

    } catch (e) {
        console.log(e)
    }
}