import React from "react";
import { useNavigate } from "react-router-dom";
import EmailLogin from "./EmailLogin";
import { HomeButton, LoginButton, LoginPageBox, StyledDiv } from "./Box";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import { CLIENT_ID } from "../../constant/KakaoAuthSecret";
import { FRONTEND_ADDRESS } from "../../constant/ADDRESS";

function LoginPage() {
  const navigate = useNavigate();
  if (localStorage.getItem(ACCESS_TOKEN)) {
    alert("이미 로그인 되어있습니다!!!!");
    window.location.href = "/";
  }
  return (
    <>
      <HomeButton
        onClick={() => {
          navigate("/");
        }}
      />
      <LoginPageBox>
        <EmailLogin navigate={navigate} />
        <LoginButton
          style={{
            color: "yellow",
            borderColor: "yellow",
          }}
          href={
            "https://kauth.kakao.com/oauth/authorize?client_id=" +
            CLIENT_ID +
            "&redirect_uri=" +
            FRONTEND_ADDRESS +
            "/login/kakao&response_type=code"
          }
        >
          카카오로그인
        </LoginButton>
        <StyledDiv
          onClick={() => {
            navigate("/signup");
          }}
        >
          PocketMoney 회원가입
        </StyledDiv>
      </LoginPageBox>
    </>
  );
}

export default LoginPage;
