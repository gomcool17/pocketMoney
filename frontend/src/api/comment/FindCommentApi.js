import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function findCommentApi(accesstoken, boardId, page) {
  const config = {
    headers: {
      "X-AUTH-TOKEN": accesstoken,
    },
  };
  return axios
    .get(BACKEND_ADDRESS + "/comments/" + boardId + "/" + page, config)
    .then((response) => response.data);
}

export default findCommentApi;
