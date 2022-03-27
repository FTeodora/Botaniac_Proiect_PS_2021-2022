package com.botaniac.forumsservice.model.entity;

import com.botaniac.forumsservice.model.enums.ForumSection;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Builder
public class Discussion {
    @Id
    @Column(name="discussion_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long discussionId;
    @Column
    private String title;
    @Column
    private ForumSection section;
    @Column
    private boolean isLocked;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column
    @CreationTimestamp
    private Date dateAdded;
    @OneToMany(mappedBy = "parentDiscussion",cascade = CascadeType.ALL)
    private List<Message> messages;
}
