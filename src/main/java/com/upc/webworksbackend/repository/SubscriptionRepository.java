package com.upc.webworksbackend.repository;
import com.upc.webworksbackend.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel,Integer> {
    ///SubcripcionActivaHasta la fecha
    @Query(value = "select s.*\n" +
            "from subscription s\n" +
            "join user u on s.id_user=u.id\n" +
            "where u.id=:id and s.date_end>:date", nativeQuery = true)
    List<SubscriptionModel> SubscriptionsActivas(@Param("id") Integer id, @Param("date") Date date);

    /// Subscription by idUser
    List<SubscriptionModel> findSubscriptionModelByUserSubscription_Id(Integer id);
}
