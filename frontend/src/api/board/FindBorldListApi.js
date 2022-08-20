import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function findBorldListApi(num) {
  return axios
    .get(BACKEND_ADDRESS + "/boards/list/" + num)
    .then((response) => response.data);
}

export default findBorldListApi;
