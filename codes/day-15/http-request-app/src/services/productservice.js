//1. fetch() API of browser (DOM library)
//2. axios package: 3rd party package

//call RESTful API to get all records of employees
//url: http://localhost:8001/employees/sort/{sortchoice} (GET)

const baseUrl = 'http://localhost:8001/employees/'
function getEmployees() {

}
//call RESTful API to get a single record of an employee
//url: http://localhost:8001/employees/view/{eid} (GET)
function getEmployee(id) {

}
//call RESTful API to pass a newly created employee data
//so that it can saved in the database table
//url: http://localhost:8001/employees/add (POST)
function addEmployee(empObject) {

}

//call RESTful API to pass a newly updated an existing employee data so that it can updated also in the database table
//url: http://localhost:8001/employees/update/{eid} (PUT)
function updateEmployee(id, empObject) {

}
//call RESTful API to delete an employee record from database tabke
//url: http://localhost:8001/employees/delete/{eid} (DELETE)
function deleteEmployee(id) {

}
