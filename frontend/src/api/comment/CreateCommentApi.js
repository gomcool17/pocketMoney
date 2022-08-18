import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function createCommentApi(boardId, content, accesstoken) {
  const config = {
    headers: {
      "X-AUTH-TOKEN": accesstoken,
    },
  };
  const body = {
    text: content,
  };
  return axios
    .post(BACKEND_ADDRESS + "/comments/" + boardId, body, config)
    .then((response) => {
      if (response.status === 200) {
        alert("작성이 완료되었습니다");
        return response.data;
      }
    })
    .catch((error) => {
      if (error.response.status === 401 || error.response.status === 403) {
        alert(error.response.data.errorMessage);
        return Promise.reject();
      }
    });
}

export default createCommentApi;
