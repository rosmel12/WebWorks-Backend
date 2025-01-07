package com.upc.webworksbackend.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemScoreDto {
    private Integer id;
    private Date dateScore;
    private Integer id_user;
    private Integer id_commentProfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_commentProfile() {
        return id_commentProfile;
    }

    public void setId_commentProfile(Integer id_commentProfile) {
        this.id_commentProfile = id_commentProfile;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Date getDateScore() {
        return dateScore;
    }

    public void setDateScore(Date dateScore) {
        this.dateScore = dateScore;
    }
}
