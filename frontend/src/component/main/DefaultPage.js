import styled from "styled-components";
import MainHeader from "../MainHeader";
import Boards from "./Boards";
import { useNavigate } from "react-router";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  -ms-user-select: none;
  -moz-user-select: -moz-none;
  -khtml-user-select: none;
  -webkit-user-select: none;
  user-select: none;
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
  const navigate = useNavigate();
  return (
    <>
      <MainHeader />
      <Outside>
        <TitleLogo>PocketMoney</TitleLogo>
        <LocalWork>근처 일자리</LocalWork>
        <FindWork
          onClick={() => {
            navigate("/board/write");
          }}
        >
          일자리 구인
        </FindWork>
        <Boards />
      </Outside>
    </>
  );
}

export default DefaultPage;
