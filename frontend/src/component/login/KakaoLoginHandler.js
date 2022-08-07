import React from "react";
import kakaoLoginApi from "./../../api/KakaoLoginApi";
import { useNavigate } from "react-router";

function KakaoLoginHandler() {
  const navigate = useNavigate();
  const params = new URLSearchParams(window.location.search);
  let code = params.get("code");
  kakaoLoginApi(code, navigate);
  return <></>;
}

export default KakaoLoginHandler;
