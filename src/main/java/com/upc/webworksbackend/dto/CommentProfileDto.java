package com.upc.webworksbackend.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentProfileDto {
    private Integer id;
    private int score;
    private String comment;
    private Integer id_user;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}
