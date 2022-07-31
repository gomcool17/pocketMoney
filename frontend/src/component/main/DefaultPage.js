import styled from "styled-components";
import MainHeader from "../MainHeader";
import Boards from "./Boards";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
`;
const TitleLogo = styled.div`
  width: 1050px;
  height: 250px;
  background-color: lightgreen;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`;
const LocalWork = styled.div`
  width: 1050px;
  height: 250px;
  background-color: yellow;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`;
const FindWork = styled.div`
  width: 1050px;
  height: 250px;
  background-color: pink;
  font-size: 50px;
  line-height: 250px;
  text-align: center;
`;

function DefaultPage() {
  return (
    <>
      <MainHeader />
      <Outside>
        <TitleLogo>PocketMoney</TitleLogo>
        <LocalWork>근처 일자리</LocalWork>
        <FindWork>일자리 구인</FindWork>
        <Boards />
      </Outside>
    </>
  );
}

export default DefaultPage;
