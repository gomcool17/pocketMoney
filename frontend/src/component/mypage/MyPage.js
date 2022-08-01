import React from "react";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";

function Mypage() {
  if (!localStorage.getItem(ACCESS_TOKEN)) {
    alert("로그인이 필요한 서비스입니다!!!");
    window.location.href = "/login";
  }
  return <></>;
}

export default Mypage;
