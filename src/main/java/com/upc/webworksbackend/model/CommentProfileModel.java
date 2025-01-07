package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "commentprofile")
public class CommentProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "comment", nullable = false)
    private String comment;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserModel getUserCommentProfile() {
        return userCommentProfile;
    }

    public void setUserCommentProfile(UserModel userCommentProfile) {
        this.userCommentProfile = userCommentProfile;
    }

    /// relation-User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userCommentProfile;

    ///relation-SystemScore
    @OneToOne(mappedBy ="commentProfileSystemScore", cascade = CascadeType.ALL)
    private SystemScoreModel systemScore;
}
