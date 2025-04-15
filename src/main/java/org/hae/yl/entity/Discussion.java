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
public class Discussion {

    @TableId("id")
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("creator_id")
    private Integer creator_id;

    @TableField("created_at")
    private LocalDateTime created_at;

    @TableField("updated_at")
    private LocalDateTime updated_at;
}
