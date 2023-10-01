package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// ORM -> Java(다른언어)object -> 테이블로 매핑해주는 기술
@Entity // User클래스가 MySQL에 테이블에 생성이 된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!
@DynamicInsert // insert시 null 인필드를 제외시켜준다.
public class User {

    // auto_increment가 되기때문에 우리가 입력안해도 됨!
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 123456 => 해쉬 (비밀번호 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    // @ColumnDefault( " 'user' ")
    @Enumerated(EnumType.STRING) // 디비는 이넘이 없기때문에 이넘이 스트링이라는 타입이라고 알려줘야 한다.
    private RoleType role; //ADMIN,USER
    // Enum을 쓰는게 좋다. // admin, user, manager  (managerrrr) 오타가 나올수도 있다..
    // 그래서 오타가 나오지 않게 enum을 통해서 도메인을 설정해주는거다.
    // 도메인이란 어떠한 것에 대하여 범위를 설정해주는것이다.

    // auto_increment가 되기때문에 우리가 입력안해도 됨!
    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate; // 회원이 가입했을때의 시간 을 말함
}
