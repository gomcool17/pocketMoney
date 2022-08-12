import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";

function kakaoLoginApi(code, navigate) {
  axios.post(BACKEND_ADDRESS + "/login/kakao?code=" + code).then((response) => {
    if (response.status === 200) {
      sessionStorage.setItem(ACCESS_TOKEN, response.data.jwtToken);
      navigate("/");
    }
  });
}

export default kakaoLoginApi;
