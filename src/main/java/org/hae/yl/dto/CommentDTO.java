package org.hae.yl.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private String content;
    private Integer createdBy;
    private LocalDateTime createdAt;







}
