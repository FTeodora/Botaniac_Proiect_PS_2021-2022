package com.botaniac.plantsservice.model.entity.document;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="plant_document")
@Builder
public class PlantDocument {
    @Id
    @Column(name="document_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(nullable = false)
    private String title;
    @Column
    private boolean isTrustedAuthor;
    @Column(nullable = false)
    private Date dateAdded;
    @Column
    @ColumnDefault(value = "NULL")
    private Date lastModified;
    @Column
    private String author;
    @OneToOne
    @JoinColumn(name="plant_id",referencedColumnName = "plant_id")
    private Plant plant;
    @Column
    private String documentPath;
}
