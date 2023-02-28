package kr.taehoon.exercise.entity;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UPPER_BODY")
public class UpperBody {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MUSCULER_ID")
    private MusculerStrength musculerStrength;

    @OneToMany(mappedBy = "upperBody", cascade = CascadeType.ALL)
    @Builder.Default
    private List<BackExercise> backExerciseList = new ArrayList<>();

    public void setMusculerStrength(MusculerStrength musculerStrength) {
        if (this.musculerStrength != null) {
            this.musculerStrength.getUpperBodyList().remove(this);
        }
        this.musculerStrength = musculerStrength;
        musculerStrength.getUpperBodyList().add(this);
    }
}
