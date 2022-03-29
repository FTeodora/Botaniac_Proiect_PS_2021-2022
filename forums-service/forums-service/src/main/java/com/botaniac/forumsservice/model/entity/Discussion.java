package com.botaniac.forumsservice.model.entity;

import com.botaniac.forumsservice.model.enums.ForumSection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Builder
@Getter
@Setter
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
    @ColumnDefault(value = "false")
    private boolean isLocked;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column
    @CreationTimestamp
    private Date dateAdded;
    @OneToMany(mappedBy = "parentDiscussion",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Message> messages;
}
