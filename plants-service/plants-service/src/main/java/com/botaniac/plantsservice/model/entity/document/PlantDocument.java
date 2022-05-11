package com.botaniac.plantsservice.model.entity.document;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
    @CreationTimestamp
    private Date dateAdded;
    @Column
    @ColumnDefault(value = "NULL")
    @UpdateTimestamp
    private Date lastModified;
    @Column
    private String author;
    @Column
    private String documentPath;
    @Column
    private Boolean pending;
}
