import React from "react";
import { useNavigate } from "react-router";
import kakaoLoginApi from "./../../api/login/KakaoLoginApi";

function KakaoLoginHandler() {
  const navigate = useNavigate();
  const params = new URLSearchParams(window.location.search);
  let code = params.get("code");
  kakaoLoginApi(code, navigate);
  return <></>;
}

export default KakaoLoginHandler;
