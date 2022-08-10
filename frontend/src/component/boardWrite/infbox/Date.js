import React, { useState } from "react";
import styled from "styled-components";

const DayDiv = styled.div`
  display: inline-block;
  width: 40px;
  height: 30px;
  font-size: 20px;
`;
const DayInput = styled.input`
  display: inline-block;
  font-size: 20px;
  width: 50px;
  height: 30px;
  margin-right:10px;
  border: 1px solid gray;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;
function Date() {
  const [year, setYear] = useState();
  const [month, setMonth] = useState();
  const [day, setDay] = useState();
  const [hour, setHour] = useState();
  const [minute, setMinute] = useState();

  const STARTDATE_LIST = [
    { name: "년,", value: year, setMethod: setYear, maxLength: 4 },
    { name: "월,", value: month, setMethod: setMonth, maxLength: 2 },
    { name: "일,", value: day, setMethod: setDay, maxLength: 2 },
    { name: "시,", value: hour, setMethod: setHour, maxLength: 2 },
    { name: "분", value: minute, setMethod: setMinute, maxLength: 2 },
  ];

  return (
    <>
      <DayDiv style={{ width: "100px" }}>시작날짜:</DayDiv>
      {STARTDATE_LIST.map((item) => {
        return (
          <>
            <DayInput
              value={item.value}
              onChange={(e) => item.setMethod(e.target.value)}
              maxLength={item.maxLength}
            />
            <DayDiv>{item.name}</DayDiv>
          </>
        );
      })}
    </>
  );
}

export default Date;
