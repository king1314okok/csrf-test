import axios from 'axios'

const axiosInstance = axios

axiosInstance.defaults.baseURL = '/api'

export default axiosInstance
