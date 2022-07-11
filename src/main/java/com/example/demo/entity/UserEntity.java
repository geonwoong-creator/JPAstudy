package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long pid;

    @Column(nullable = false, unique = true, length = 30)

    private String userid;

    @Column(nullable = false, length = 100)
    private String name;

    public UserEntity(String userid, String name) {
        this.userid = userid;
        this.name = name;
    }
}
