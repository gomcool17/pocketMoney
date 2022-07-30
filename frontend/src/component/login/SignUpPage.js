import React, {useState} from 'react';
import {HomeButton, LoginButton, StyledInput, SignUpPageBox} from "./Box";
import { useNavigate } from 'react-router-dom';

const SignUpPage = (props) => {
  const navigate = useNavigate(); 

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [checkPassword, setCheckPassword] = useState("");
  const [nickName, setNickName] = useState("");

  return (<>
      <HomeButton onClick={()=>{navigate("/")}}/>
      <SignUpPageBox>
        <StyledInput
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder={"이메일"}
        />
        <StyledInput
            type='password'
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder={"비밀번호"}
        />
        <StyledInput
            type='password'
            value={checkPassword}
            onChange={e => setCheckPassword(e.target.value)}
            placeholder={"비밀번호 재확인"}
        />
        <StyledInput
            value={nickName}
            onChange={e => setNickName(e.target.value)}
            placeholder={"이름"}
        />
        <LoginButton
            onClick={() => {
              if(email.length && password.length && checkPassword.length && nickName.length){
                if(password === checkPassword){
                  //회원가입 진행
                }
                else
                  alert("비밀번호가 일치하지 않습니다");
              }
              else{
                alert("빈칸을 다 채워주세요");
              }
              }}>가입하기</LoginButton>
      </SignUpPageBox>
  </>);
};

export default SignUpPage;