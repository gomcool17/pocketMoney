package com.web.pocketmoney.entity.room;

import com.web.pocketmoney.entity.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {

    //방 주소를 통해 ChatRoomEntity 가져오기
//    ChatRoom findByRoomId(String roomId);

    @Query("select cr, m" +
            " from ChatRoom cr left join Message m on m.chatRoom = cr.id" +
            " where cr.id = :id")
    List<Object[]> findByUserIdWithMessages(@Param("id") ChatRoom id);

    @Query("select cr" +
            " from ChatRoom cr " +
            " where cr.employeeId = :userId or cr.employerId = :userId")
    List<ChatRoom> findAllByEmployeeOrEmployer(Sort sort, @Param("userId") User userId);

}