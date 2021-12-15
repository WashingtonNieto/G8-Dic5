package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.Order;
import com.g8Dic5.demo.repositories.CRUD.IOrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private IOrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    //Metodos Reto 4
    //Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id){
        Query query = new Query();

        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    //Ordenes de un asesor x estado
    public List<Order> ordersSalesManByState(String state, Integer id){
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);
        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query,Order.class);
        return orders;
    }

    //Ordenes de un asesor x fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriterio = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr,dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr,dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriterio);

        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }


}
