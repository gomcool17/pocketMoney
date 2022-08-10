import React, { useState } from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import CancelButton from "../CancelButton";
import TitleBlock from "./TitleBlock";
import ContentBox from "./ContentBox";
import { useNavigate } from "react-router";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import writeBoardApi from "./../../api/WriteBoardApi";
import DayOfWeek from "./infbox/DayOfWeek";
import Date from "./infbox/Date";
import ImgUpload from "./infbox/ImgUpload";

const Outside = styled.div`
  width: 800px;
  margin: 0 auto;
  border: 1px solid blue;
`;
const WriteButton = styled.div`
  width: 200px;
  height: 50px;
  margin: 5px auto;
  font-size: 30px;
  background-color: lightGreen;
  text-align: center;
  line-height: 50px;
  cursor: pointer;
`;

const InfBox = styled.div`
  width: 800px;
  height: 350px;
  padding-top: 20px;
`;
const InfBlock = styled.div`
  width: 800px;
  height: 70px;
  padding-left: 20px;
`;
const StyledDiv = styled.div`
  display: inline-block;
  width: 100px;
  height: 30px;
  font-size: 30px;
`;
const StyledInput = styled.input`
  display: inline-block;
  font-size: 30px;
  width: 100px;
  background-color: #00000000;
  height: 30px;
  margin-right:10px;
  border: 1px solid gray;
  &:focus {
    InfBox: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;

function BoardWrite() {
  const accessToken = localStorage.getItem(ACCESS_TOKEN);
  if (!accessToken) {
    alert("로그인이 필요한 서비스입니다!!!");
    window.location.href = "/login";
  }
  const navigate = useNavigate();

  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [dayOfWeek, setDayOfWeek] = useState([]);
  const [year, setYear] = useState("");
  const [month, setMonth] = useState("");
  const [day, setDay] = useState("");
  const [hour, setHour] = useState("");
  const [minute, setMinute] = useState("");
  const [pay, setPay] = useState("");
  return (
    <>
      <MainHeader />
      <Outside>
        <CancelButton navigate={navigate} />
        <TitleBlock title={title} setTitle={setTitle} />
        <InfBox>
          <InfBlock>
            <StyledDiv>시급:</StyledDiv>
            <StyledInput value={pay} onChange={(e) => setPay(e.target.value)} />
            <StyledDiv>원</StyledDiv>
          </InfBlock>
          <InfBlock>
            <StyledDiv>지역:</StyledDiv>
            <StyledInput
              type="text"
              id="pInput"
              readOnly={true}
              placeholder={"도시"}
              onClick={() => {
                window.name = "parentForm";
                window.open(
                  "/signup/city",
                  "childForm",
                  "top=10, left=10, width=650, height=600, status=no, menubar=no, toolbar=no, resizable=no"
                );
              }}
            />
          </InfBlock>
          <InfBlock>
            <StyledDiv>요일:</StyledDiv>
            <DayOfWeek dayOfWeek={dayOfWeek} setDayOfWeek={setDayOfWeek} />
          </InfBlock>
          <InfBlock>
            <Date
              year={year}
              setYear={setYear}
              month={month}
              setMonth={setMonth}
              day={day}
              setDay={setDay}
              hour={hour}
              setHour={setHour}
              minute={minute}
              setMinute={setMinute}
            />
          </InfBlock>
          <InfBlock>
            <ImgUpload />
          </InfBlock>
        </InfBox>
        <ContentBox content={content} setContent={setContent} />
        <WriteButton
          onClick={() => {
            if (
              title.length &&
              content.length &&
              document.getElementById("pInput").value &&
              dayOfWeek.length &&
              year.length &&
              month.length &&
              day.length &&
              hour.length &&
              minute.length &&
              pay.length
            ) {
              writeBoardApi(
                title,
                content,
                document.getElementById("pInput").value,
                dayOfWeek,
                year,
                month,
                day,
                hour,
                minute,
                pay,
                accessToken,
                navigate
              );
            } else {
              alert("빈칸을 다 채워주세요");
            }
          }}
        >
          작성하기
        </WriteButton>
      </Outside>
    </>
  );
}

export default BoardWrite;
