package kr.taehoon.exercise.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition="TIMESTAMP")
    @CreationTimestamp
    private ZonedDateTime createTime = ZonedDateTime.now();
}
