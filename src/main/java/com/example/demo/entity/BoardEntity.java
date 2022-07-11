package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long board_seq;

    @Column(nullable = false, length = 50)
    private String id;

    @Column(nullable = false, length = 100)
    private String content;

    public BoardEntity(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
