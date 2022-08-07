/* eslint-disable jsx-a11y/img-redundant-alt */
import React, { useState } from "react";
import styled from "styled-components";
import { useNavigate } from "react-router";
import { ACCESS_TOKEN } from "../constant/LocalStorage";

const Header = styled.div`
  min-width: 1050px;
  height: 50px;
  position: sticky;
  top: 0;
  background-color: aquamarine;
  z-index: 2;
`;
const HeaderInside = styled.div`
  position: absolute;
  display: flex;
  width: 1050px;
  height: 50px;
  top: 0;
  left: 50%;
  transform: translate(-50%, 0%);
`;
const Logo = styled.div`
  margin-right: auto;
  border: 5px solid blue;
  height: 40px;
  width: 300px;
  text-align: center;
  font-size: 30px;
  cursor: pointer;
`;
const RightHeader = styled.div`
  margin-left: auto;
  margin-top: 5px;
  width: 50%;
  text-align: center;
  font-size: 20px;
  height: 30px;
`;
const Search = styled.div`
  display: inline-block;
  width: 250px;
  background: #f7f7f7;
  border-radius: 18px;
`;
const Searchinput = styled.input`
  width: 200px;
  height: 25px;
  border: none;
  background: none;
`;
const Serachsubmit = styled.button`
  border: none;
  background: none;
`;
const Login = styled.div`
  display: inline-block;
  margin-left: 5px;
  width: 100px;
  cursor: pointer;
  border: 5px solid blue;
`;
const SignUp = styled.div`
  display: inline-block;
  margin-left: 20px;
  width: 100px;
  cursor: pointer;
  border: 5px solid blue;
`;
const Mypage = styled.div`
  display: inline-block;
  margin-left: 20px;
  width: 100px;
  cursor: pointer;
  border: 5px solid blue;
`;
const Logout = styled.div`
  display: inline-block;
  margin-left: 5px;
  width: 100px;
  cursor: pointer;
  border: 5px solid blue;
`;

function MainHeader() {
  const navigate = useNavigate();
  const token = localStorage.getItem(ACCESS_TOKEN);
  const [sword, setSword] = useState("");
  const search = () => {
    if (!sword.length) {
      alert("검색어를 입력해주세요");
    } else {
      alert(sword);
      setSword("");
    }
  };
  const enterKey = () => {
    if (window.event.keyCode === 13) {
      search();
    }
  };
  return (
    <Header>
      <HeaderInside>
        <Logo
          onClick={() => {
            window.location.href = "/";
          }}
        >
          PocketMoney
        </Logo>
        <RightHeader>
          <Search>
            <Searchinput
              type="text"
              value={sword}
              onChange={(e) => setSword(e.target.value.trim())}
              onKeyUp={enterKey}
            />
            <Serachsubmit>
              <img
                src="/search.png"
                alt="my image"
                style={{
                  marginTop: "5px",
                  width: "20px",
                  height: "20px",
                  cursor: "pointer",
                }}
                onClick={search}
              />
            </Serachsubmit>
          </Search>
          {token === null ? (
            <>
              <SignUp
                onClick={() => {
                  navigate("/signup");
                }}
              >
                회원가입
              </SignUp>
              <Login
                onClick={() => {
                  navigate("/login");
                }}
              >
                로그인
              </Login>
            </>
          ) : (
            <>
              <Mypage
                onClick={() => {
                  navigate("/mypage");
                }}
              >
                마이페이지
              </Mypage>
              <Logout
                onClick={() => {
                  localStorage.removeItem(ACCESS_TOKEN);
                  alert("로그아웃 되었습니다.");
                  navigate("/");
                }}
              >
                로그아웃
              </Logout>
            </>
          )}
        </RightHeader>
      </HeaderInside>
    </Header>
  );
}

export default MainHeader;
