package com.botaniac.forumsservice.model.entity;

import com.botaniac.forumsservice.model.enums.ForumSection;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {
    @Id
    @Column(name="discussion_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private ForumSection section;
    @Column
    @ColumnDefault(value = "false")
    private Boolean isLocked;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column
    @CreationTimestamp
    private LocalDateTime dateAdded;
    @Column
    private String author;
    @OneToMany(mappedBy = "parentDiscussion",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Message> messages;
}
