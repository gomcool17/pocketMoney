import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";

function loginApi(email, password, navigate) {
  const body = {
    email: email,
    password: password,
  };

  axios
    .post(BACKEND_ADDRESS + "/login/", body)
    .then((response) => {
      if (response.status === 200) {
        alert("로그인이 완료되었습니다.");
        sessionStorage.setItem(ACCESS_TOKEN, response.data.data.token);
        navigate("/");
      }
    })
    .catch((error) => {
      if (error.response.status === 401 || error.response.status === 400) {
        alert("가입하지 않은 이메일이거나, 잘못된 비밀번호 입니다");
        return Promise.reject();
      }
      alert("이메일 로그인 실패!");
      navigate("/");
    });
}

export default loginApi;
