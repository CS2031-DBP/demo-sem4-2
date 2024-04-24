package com.example.demo.orderdetail.infrastructure;

import com.example.demo.orderdetail.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
