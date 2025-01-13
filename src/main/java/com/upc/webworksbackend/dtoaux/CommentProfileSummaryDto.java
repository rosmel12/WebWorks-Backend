package com.upc.webworksbackend.dtoaux;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public Integer getId_user_comment() {
        return id_user_comment;
    }

    public void setId_user_comment(Integer id_user_comment) {
        this.id_user_comment = id_user_comment;
    }

    public Integer getId_system_score() {
        return id_system_score;
    }

    public void setId_system_score(Integer id_system_score) {
        this.id_system_score = id_system_score;
    }
}
