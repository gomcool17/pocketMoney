import { BACKEND_ADDRESS } from "../../constant/ADDRESS";
import axios from "axios";
import findCommentApi from "./FindCommentApi";

function deleteCommentApi(
  boardId,
  commentId,
  accesstoken,
  comments,
  setComments
) {
  if (!accesstoken) {
    alert("로그인이 필요한 서비스입니다.");
    return Promise.reject("토큰이 없음");
  }
  const config = {
    headers: {
      "X-AUTH-TOKEN": accesstoken,
    },
  };
  axios
    .delete(BACKEND_ADDRESS + "/comments/" + boardId + "/" + commentId, config)
    .then((response) => {
      if (response.status === 200) {
        alert("댓글이 삭제되었습니다 :)");
        findCommentApi(accesstoken, boardId, 1).then((dataPromise) => {
          setComments(dataPromise);
        });
      }
    })
    .catch((error) => {
      alert(error.response.data.errorMessage);
      return Promise.reject();
    });
}

export default deleteCommentApi;
