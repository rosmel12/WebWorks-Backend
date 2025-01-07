package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.CommentProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentProfileRepository extends JpaRepository<CommentProfileModel,Integer> {
}
