package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "systemscore")
public class SystemScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dateScore", nullable = false)
    private Date dateScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateScore() {
        return dateScore;
    }

    public void setDateScore(Date dateScore) {
        this.dateScore = dateScore;
    }

    public UserModel getUserSystemScore() {
        return userSystemScore;
    }

    public void setUserSystemScore(UserModel userSystemScore) {
        this.userSystemScore = userSystemScore;
    }

    public CommentProfileModel getCommentProfileSystemScore() {
        return commentProfileSystemScore;
    }

    public void setCommentProfileSystemScore(CommentProfileModel commentProfileSystemScore) {
        this.commentProfileSystemScore = commentProfileSystemScore;
    }

    ///relation-user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userSystemScore;

    ///relation-CommentProfile
    @OneToOne
    @JoinColumn(name="id_commentprofile" ,nullable=false)
    private CommentProfileModel commentProfileSystemScore;


}
