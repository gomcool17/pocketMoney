package com.web.pocketmoney.entity.notification;

import com.web.pocketmoney.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long receiverId;

    @Column(nullable = false, length = 255)
    private String message;

    @Column(nullable = false)
    private boolean nRead;

}
