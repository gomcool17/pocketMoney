import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function findBoardApi(accesstoken, boardId) {
  const config = {
    headers: {
      "X-AUTH-TOKEN": accesstoken,
    },
  };
  return axios
    .get(BACKEND_ADDRESS + "/boards/" + boardId, config)
    .then((response) => response.data);
}

export default findBoardApi;
