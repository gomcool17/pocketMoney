import React, { useState } from "react";
import { LoginButton, StyledInput } from "./Box";
import loginApi from "./../../api/LoginApi";

const EmailLogin = (props) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  return (
    <>
      <StyledInput
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder={"이메일"}
      />
      <StyledInput
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder={"비밀번호"}
      />
      <LoginButton
        onClick={() => {
          if (email.length && password.length) {
            setPassword("");
            loginApi(email, password, props.navigate);
          } else {
            alert("빈칸을 다 채워주세요!");
          }
        }}
      >
        로그인
      </LoginButton>
    </>
  );
};

export default EmailLogin;
