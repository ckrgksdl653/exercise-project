package kr.taehoon.exercise.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BACK")
@Entity
public class BackExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "WEIGHT")
    private double weight;

    @Setter
    @Column(nullable = false, name = "COUNT")
    private int count;

    @Setter
    @Column(nullable = false, name = "TYPE_ID")
    private String typeId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "UPPER_ID")
    private UpperBody upperBody;

    public void setUpperBody(UpperBody upperBody) {
        if (this.upperBody != null) {
            this.upperBody.getBackExerciseList().remove(this);
        }
        this.upperBody = upperBody;
        upperBody.getBackExerciseList().add(this);
    }
}
