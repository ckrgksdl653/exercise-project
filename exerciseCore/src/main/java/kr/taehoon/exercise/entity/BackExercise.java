package kr.taehoon.exercise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class BackExercise extends Exercise {

    @Column(name = "weight")
    private double weight;

    @Column(nullable = false, name = "count")
    private int count;
}
