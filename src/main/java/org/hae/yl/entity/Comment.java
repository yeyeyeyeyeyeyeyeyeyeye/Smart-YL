package org.hae.yl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Comment {

    @TableId("id")
    private Integer id;

    @TableField("discussion_id")
    private Integer discussion_id;

    @TableField("user_id")
    private Integer user_id;

    @TableField("content")
    private String content;

    @TableField("parent_id")
    private Integer parent_id;

    @TableField("created_at")
    private LocalDateTime created_at;

    @TableField("updated_at")
    private LocalDateTime updated_at;
}
