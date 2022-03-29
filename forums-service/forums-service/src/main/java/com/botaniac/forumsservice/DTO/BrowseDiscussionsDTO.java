package com.botaniac.forumsservice.DTO;

import com.botaniac.forumsservice.model.enums.ForumSection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

@Builder
@Getter
@Setter
public class BrowseDiscussionsDTO {
    private long discussionId;
    private String title;
    private boolean isLocked;
    private Date dateAdded;
}
