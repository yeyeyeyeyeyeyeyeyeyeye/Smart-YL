package org.hae.yl.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscussionDetailDTO {

    private String title;
    private String content;
    private Integer createdBy;
    private LocalDateTime createdAt;
    private List<CommentDTO> comments;



}
