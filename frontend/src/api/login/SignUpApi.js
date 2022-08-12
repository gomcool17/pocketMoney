import axios from "axios";
import { BACKEND_ADDRESS } from "./../../constant/ADDRESS";

function signUpApi(
  email,
  password,
  nickName,
  age,
  sex,
  city,
  userName,
  navigate
) {
  const body = {
    age: age,
    city: city,
    email: email,
    nickName: nickName,
    password: password,
    sex: sex,
    userName: userName,
  };

  axios
    .post(BACKEND_ADDRESS + "/login/signup", body)
    .then((response) => {
      if (response.status === 200) {
        alert("회원가입이 완료되었습니다");
        navigate("/login");
      }
    })
    .catch((error) => {
      if (error.response.status === 401 || error.response.status === 400) {
        alert(error.response.data.errorMessage);
        return Promise.reject();
      }
      alert("뭔지 모르지만 회원가입실패?! 홈으로..");
      navigate("/");
    });
}

export default signUpApi;
