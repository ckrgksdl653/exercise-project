package kr.taehoon.exercise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Entity
public class BackExercise {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "weight")
    private double weight;

    @Column(nullable = false, name = "count")
    private int count;
}
