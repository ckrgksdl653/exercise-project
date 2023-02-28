package kr.taehoon.exercise.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MUSCULER_STRENGTH")
public class MusculerStrength {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_TIME", columnDefinition="TIMESTAMP")
    @CreationTimestamp
    @Builder.Default
    private ZonedDateTime createTime = ZonedDateTime.now();

    @OneToMany(mappedBy = "musculerStrength", cascade = CascadeType.ALL)
    @Builder.Default
    private List<UpperBody> upperBodyList = new ArrayList<>();
}
