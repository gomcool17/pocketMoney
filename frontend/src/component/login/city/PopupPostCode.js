import React from "react";
import DaumPostcode from "react-daum-postcode";

const PopupPostCode = () => {
  // 우편번호 검색 후 주소 클릭 시 실행될 함수, data callback 용
  const handlePostCode = (data) => {
    window.opener.document.getElementById("pInput").value = data.sigungu;
    window.close();
  };

  const postCodeStyle = {
    display: "block",
    width: "100%",
    height: "500px",
    padding: "7px",
  };

  return (
    <>
      <DaumPostcode style={postCodeStyle} onComplete={handlePostCode} />
    </>
  );
};

export default PopupPostCode;
