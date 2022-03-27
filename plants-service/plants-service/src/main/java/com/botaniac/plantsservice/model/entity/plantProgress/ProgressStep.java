package com.botaniac.plantsservice.model.entity.plantProgress;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="progress_step")
@Builder
public class ProgressStep {
    @Id
    @Column(name="progress_step_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stepId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="progress_id",referencedColumnName = "progress_id")
    private PersonalPlantProgress parentProgress;
    @Column
    private String description;
    @Column
    @CreationTimestamp
    private Date createdAt;
}
