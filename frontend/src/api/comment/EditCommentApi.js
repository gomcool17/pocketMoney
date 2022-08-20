import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function editCommentApi(boardId, commentId, content, accesstoken) {
  const config = {
    headers: {
      "X-AUTH-TOKEN": accesstoken,
    },
  };
  const body = {
    text: content,
  };
  return axios
    .put(
      BACKEND_ADDRESS + "/comments/" + boardId + "/" + commentId,
      body,
      config
    )
    .then((response) => {
      if (response.status === 200) {
        alert("수정이 완료되었습니다");
        return response.data;
      }
    })
    .catch((error) => {
      alert(error.response.data.errorMessage);
      return Promise.reject();
    });
}

export default editCommentApi;
