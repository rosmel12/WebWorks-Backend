package com.upc.webworksbackend.repository;
import com.upc.webworksbackend.model.SystemScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemScoreRepository extends JpaRepository<SystemScoreModel, Long> {
    //consulta mayor puntaje
    @Query(value = "select max(s.score), s.developer_id\n" +
            "from systemscore s\n" +
            "where s.developer_id=:id\n" +
            "group by s.developer_id",nativeQuery = true)
    List<Object[]> getMaxScore(@Param("id") Integer id);
}
