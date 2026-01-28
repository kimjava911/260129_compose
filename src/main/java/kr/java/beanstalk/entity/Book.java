package kr.java.beanstalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ZonedDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = ZonedDateTime.now();
    }
}
