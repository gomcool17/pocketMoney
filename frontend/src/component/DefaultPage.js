/* eslint-disable jsx-a11y/img-redundant-alt */
import React, {useState} from 'react';
import styled from 'styled-components';

const Header = styled.div`
  min-width: 1050px;
  height: 50px;
  position: sticky;
  top: 0;
  background-color: aquamarine;
`
const HeaderInside = styled.div`
  position: absolute;
  display: flex;
  width: 1050px;
  height: 50px;
  top: 0;
  left: 50%;
  transform: translate(-50%, 0%);
`
const Logo = styled.div`
  margin-right: auto;
  border: 5px solid blue;
  height: 40px;
  width: 300px;   
   
  font-size: 30px;
  cursor: pointer;
`
const RightHeader = styled.div`
  margin-left: auto;
  margin-top: 5px;
  width: 50%;   
  text-align: center;
  font-size: 20px;
  height: 30px;
`
const Search = styled.div`
  display: inline-block;
  width:250px;
  background: #f7f7f7; 
  border-radius: 18px; 
  `
const Searchinput = styled.input`
  width: 200px;
  height: 25px;
  border: none; 
  background: none;
  `
const Serachsubmit = styled.button`
  border: none; 
  background: none;
  `
const Login = styled.div`
  display: inline-block;
  margin-left: 5px;
  width: 100px; 
  cursor: pointer;
  border: 5px solid blue;
  `
const SignUp = styled.div`
  display: inline-block;
  margin-left: 20px;
  width: 100px;  
  cursor: pointer;
  border: 5px solid blue;
`
const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
`
const TitleLogo = styled.div`
  width: 1050px;
  height: 250px;
  background-color: lightgreen;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`
const LocalWork = styled.div`
  width: 1050px;
  height: 250px;
  background-color: yellow;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`
const FindWork = styled.div`
  width: 1050px;
  height: 250px;
  background-color: pink;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`
const Boards = styled.div`
  width: 1050px;
`
const BoardBox = styled.div`
  display: inline-block;
  width: 300px;
  height: 365px;
  border: 5px solid black;
  margin: 20px;
`
const ImgBox = styled.div`
  margin: 0 auto;
  margin-top: 15px;
  width: 250px;
  height: 200px;
  border: 5px solid blue;
`
const BoardTitle = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`
const Salary = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`
const Location = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`

const DefaultPage = (props) => {
  const [sword, setSword] = useState("")
  const search = () => {
    if (!sword.length) {
      alert("검색어를 입력해주세요")
    } else {
      alert(sword)
      setSword("")
    }
  }
  const enterKey = () => {
    if (window.event.keyCode === 13) {
      search();
    }
  }

    return (<> 
    <Header>
        <HeaderInside>
            <Logo>PocketMoney</Logo>
            <RightHeader>
              <Search>
                <Searchinput type='text'
                             value={sword}
                             onChange={e => setSword(e.target.value.trim())}
                             onKeyUp={enterKey}
                />
                <Serachsubmit><img
                    src="/search.png"
                    alt="my image"
                    style={{
                      marginTop: "5px",
                      width: "20px",
                      height: "20px",
                      cursor: "pointer"
                    }}
                    onClick={search}
                /></Serachsubmit>
              </Search>
              <SignUp>회원가입</SignUp>
              <Login>로그인</Login>
            </RightHeader>
        </HeaderInside>
    </Header>
    <Outside>
      <TitleLogo>PocketMoney</TitleLogo>   
      <LocalWork>근처 일자리</LocalWork>
      <FindWork>일자리 구인</FindWork>
      <Boards>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
      </Boards>
</Outside></>)
};

export default DefaultPage
