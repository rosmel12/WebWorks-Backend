package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel,Integer> {
//proyectodeveloperPersONA
    @Query(value = "select pr.id, pe.id  \n" +
            "from project pr\n" +
            "join person pe on pe.id=pr.user_id\n" +
            "join developer d on d.id=pr.developer_id\n" +
            "where pr.id=:id",nativeQuery = true)
    List<Object[]> ProyectoDeveloperPersona(@Param("id") Integer id);

}
