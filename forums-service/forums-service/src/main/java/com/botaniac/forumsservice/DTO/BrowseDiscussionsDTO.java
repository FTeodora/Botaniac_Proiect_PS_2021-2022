package com.botaniac.forumsservice.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrowseDiscussionsDTO {
    private Long discussionId;
    private String title;
    private Boolean isLocked;
    private LocalDateTime dateAdded;
}
