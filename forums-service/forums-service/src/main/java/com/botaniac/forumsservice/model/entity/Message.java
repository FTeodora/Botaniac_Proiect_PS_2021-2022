package com.botaniac.forumsservice.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @Column(name="message_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "discussion_id",referencedColumnName = "discussion_id")
    private Discussion parentDiscussion;
    @Column
    @CreationTimestamp
    private LocalDateTime datePosted;
}
