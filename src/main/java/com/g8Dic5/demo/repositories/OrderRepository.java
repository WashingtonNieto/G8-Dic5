package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.Order;
import com.g8Dic5.demo.repositories.CRUD.IOrderCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {


    private IOrderCrudRepository orderCrudRepository;

    public List<Order> getAll()
    {
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id){return orderCrudRepository.findById(id); }

    public Order create(Order order){
        return orderCrudRepository.save(order);
    }

    public Order update(Order order){
        return orderCrudRepository.save(order);
    }

    public void delete(Order order){
        orderCrudRepository.delete(order);
    }

    public Optional<Order> LastOrderId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

}
