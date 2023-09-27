package com.example.shop_rent_manager.service;

import com.example.shop_rent_manager.model.Item;
import com.example.shop_rent_manager.model.Order;
import com.example.shop_rent_manager.model.OrderItem;
import com.example.shop_rent_manager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class OrderService {


  @Autowired
  private OrderRepository orderRepository;
  public List<Order> listAll(String keyword) {
      if(keyword != null){
          return orderRepository.search(keyword);
      } return null;
  }
  @Autowired
  private EntityManager entityManager;
public List<Order> searchItemByName(String keyword) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> orderRoot = criteriaQuery.from(Order.class);
    Join<Order, Item> itemJoin = orderRoot.join("items", JoinType.INNER);
    Predicate likePredicate = criteriaBuilder.like(itemJoin.get("name"), "%" + keyword + "%");
    criteriaQuery.where(likePredicate);
    return entityManager.createQuery(criteriaQuery).getResultList();
}
}