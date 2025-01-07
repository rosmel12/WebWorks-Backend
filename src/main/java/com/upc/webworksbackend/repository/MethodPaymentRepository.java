package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.MethodPaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MethodPaymentRepository extends JpaRepository<MethodPaymentModel,Integer> {
    //query 1 metodo de pago por boleta
    @Query(value = "select b.id,b.date_payment,mp.cvv,mp.date_card,mp.number_card\n" +
            "from method_payment mp\n" +
            "join ballot b on b.id=mp.ballot_id\n" +
            "where b.id=:id", nativeQuery = true)
    List<Object[]> ListaMetodoPagoBoleta(@Param("id")Integer id);
}
