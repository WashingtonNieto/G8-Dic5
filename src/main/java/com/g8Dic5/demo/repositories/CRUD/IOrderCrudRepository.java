package com.g8Dic5.demo.repositories.CRUD;

import com.g8Dic5.demo.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IOrderCrudRepository extends MongoRepository<Order, Integer> {

    //Retorna las ordenes de pedido que coicidan con la zona recibida por parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);

    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
