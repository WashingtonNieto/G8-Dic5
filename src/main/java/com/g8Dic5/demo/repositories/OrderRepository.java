package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.Order;
import com.g8Dic5.demo.repositories.CRUD.IOrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    public List<Order> getAll()
    {
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id){return orderCrudRepository.findById(id); }

    public Order create(Order order){
        return orderCrudRepository.save(order);
    }

    public void update(Order order){
        orderCrudRepository.save(order);
    }

    public void delete(Order order){
        orderCrudRepository.delete(order);
    }

    public Optional<Order> LastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }

}
