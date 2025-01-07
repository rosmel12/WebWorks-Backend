package com.upc.webworksbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentProfileSummaryDto {
    private Integer id;
    private int score;
    private String comment;
    private Date commentDate;
    private String commentAuthor;
    private Integer id_user_comment;
    private Integer id_system_score;
}
