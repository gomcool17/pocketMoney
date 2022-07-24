import axios from 'axios'
import { BACKEND_ADDRESS } from '../constant/ADDRESS';

const testApi = () => {
    return axios.get(BACKEND_ADDRESS + "/boards")
  .then(response => response.data);
}

export default testApi;
