import React, { useEffect, useState } from 'react'
import testApi from '../api/TestApi';

const DefaultPage = () => {
    const [boards, setBoards] = useState("")

    useEffect(()=>{
        testApi().then(boardPromises => {
            setBoards(boardPromises)
        })
    },[])
    console.log(boards)
    return (<>< div>    
            테스트 성공!
        </div></>)
};

export default DefaultPage
