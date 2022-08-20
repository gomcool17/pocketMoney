import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";
import axios from "axios";

function searchBoardApi(search, num) {
  return axios
    .get(BACKEND_ADDRESS + "/boards/list/" + search + "/" + num)
    .then((response) => response.data);
}

export default searchBoardApi;
