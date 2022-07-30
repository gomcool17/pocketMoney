import React from 'react'
import { useNavigate } from 'react-router-dom';
import EmailLogin from './EmailLogin';
import {HomeButton, LoginButton, LoginPageBox, StyledDiv} from "./Box";

function LoginPage() {
    const navigate = useNavigate();
    return (<>
        <HomeButton onClick={()=>{navigate("/")}}/>
          <LoginPageBox>
            <EmailLogin />
            <LoginButton style={{
                  color: "yellow",
                  borderColor: "yellow"
                }}
            >카카오로그인</LoginButton >
            <LoginButton style={{
                  color: "green",
                  borderColor: "green"
                }}
            >네이버로그인</LoginButton>
            <LoginButton style={{
                  color: "gray",
                  borderColor: "gray"
                }}
            >구글로그인</LoginButton>
            <StyledDiv onClick={()=>{navigate("/signup")}}>PocketMoney 회원가입</StyledDiv>
          </LoginPageBox>
      </>);
}

export default LoginPage
