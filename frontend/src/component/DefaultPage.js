import styled from 'styled-components';

const Outside = styled.div`
  width: 1050px;
  height: 2000px;
  margin: 10px auto;
  border: 5px solid black;
`
const Header = styled.div`
  min-width: 1050px;
  height: 50px;
  border: 5px solid blue;
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
  border: 5px solid red;
  
`
const Logo = styled.div`
  margin-right: auto;
  border: 5px solid blue;
  height: 40px;
  width: 300px;   
  text-align: center;
  font-size: 30px;
  cursor: pointer;
`
const LoginBox = styled.div`
  margin-left: auto;
  margin-top: 5px;
  width: 22%;   
  text-align: center;
  font-size: 20px;
  height: 30px;
`
const Login = styled.div`
  display: inline-block;
  margin-left: 10px;
  width: 100px; 
  cursor: pointer;
  border: 5px solid blue;
`
const SignUp = styled.div`
  display: inline-block;
  width: 100px;  
  cursor: pointer;
  border: 5px solid blue;
`

const DefaultPage = () => {
    return (<> 
    <Header>
        fdsfdsfsd
        <HeaderInside>
            <Logo>PocketMoney</Logo>
            <LoginBox>
              <SignUp>회원가입</SignUp>
              <Login>로그인</Login>
            </LoginBox>
        </HeaderInside>
    </Header>
    <Outside>   
</Outside></>)
};

export default DefaultPage
