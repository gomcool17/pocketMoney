import styled from "styled-components";
import MainHeader from "../MainHeader";
import Boards from "./Boards";
import { useNavigate, useParams } from "react-router";
import Numbers from "./Numbers";
import { useState, useEffect } from "react";
import findBorldListApi from "./../../api/board/FindBorldListApi";

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
  const params = useParams;
  const num = params.num;
  const [boards, setBoards] = useState("");
  useEffect(() => {
    findBorldListApi(num ? num : 1).then((dataPromise) => {
      setBoards(dataPromise);
    });
  }, [num]);

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
        <Boards boards={boards.boards} navigate={navigate} />
        <Numbers
          start={boards.start}
          end={boards.end}
          prev={boards.prev}
          next={boards.next}
        />
      </Outside>
    </>
  );
}

export default DefaultPage;
