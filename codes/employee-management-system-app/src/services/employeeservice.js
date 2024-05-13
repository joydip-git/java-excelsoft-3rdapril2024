import axiosInstance from '../config/axios-config'
class EmployeeService {
    getEmployees(sortChoice) {
        return axiosInstance.get(`/employees/sort/${sortChoice}`)
    }
    getEmployee(id) {
        return axiosInstance.get(`/employees/view/${id}`)
    }
    addEmployee(employee) {
        return axiosInstance.post(`/employees/add`, employee)
    }
    updateEmployee(id, employee) {
        return axiosInstance.put(`/employees/update/${id}`, employee)
    }
    deleteEmployee(id) {
        return axiosInstance.delete(`/employees/delete/${id}`)
    }
}

const employeeServiceInstance = new EmployeeService()
export default employeeServiceInstance