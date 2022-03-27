package com.botaniac.plantsservice.model.entity.plantProgress;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="personal_plant_progress")
@Builder
public class PersonalPlantProgress {
    @Id
    @Column(name="progress_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="user_id")
    private String userId;
    @Column
    @CreationTimestamp
    private Date createdAt;
    @Column
    @UpdateTimestamp
    private Date lastUpdatedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="plant_id",referencedColumnName = "plant_id")
    private Plant plant;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "parentProgress")
    private List<ProgressStep> progressSteps;

}
