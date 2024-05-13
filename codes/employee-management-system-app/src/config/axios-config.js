import axios from "axios";
import { EMPLOYEE_SERVICE_BASE_URL } from "./constants";

const axiosInstance = axios.create({
    baseURL: EMPLOYEE_SERVICE_BASE_URL,
    timeout: 3000,
    timeoutErrorMessage: 'request timed out'
})
export default axiosInstance