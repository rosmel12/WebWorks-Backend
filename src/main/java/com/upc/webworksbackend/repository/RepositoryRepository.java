package com.upc.webworksbackend.repository;
import com.upc.webworksbackend.model.RepositoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRepository extends JpaRepository<RepositoryModel, Integer> {
}
