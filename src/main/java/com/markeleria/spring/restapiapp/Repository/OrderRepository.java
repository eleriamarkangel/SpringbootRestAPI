package com.markeleria.spring.restapiapp.Repository;

import com.markeleria.spring.restapiapp.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
