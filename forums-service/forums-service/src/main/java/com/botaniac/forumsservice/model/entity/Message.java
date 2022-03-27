package com.botaniac.forumsservice.model.entity;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Builder
public class Message {
    @Id
    @Column(name="message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "discussion_id",referencedColumnName = "discussion_id")
    private Discussion parentDiscussion;
    @Column
    @CreationTimestamp
    private Date datePosted;
}
