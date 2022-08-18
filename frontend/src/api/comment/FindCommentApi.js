import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function findCommentApi(accesstoken, boardId, page) {
  return axios
    .get(BACKEND_ADDRESS + "/comments/" + boardId + "/" + page)
    .then((response) => response.data);
}

export default findCommentApi;
