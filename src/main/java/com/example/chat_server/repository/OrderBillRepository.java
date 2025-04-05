package com.example.chat_server.repository;

import com.example.chat_server.entity.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill, Long> {
    List<OrderBill> findByStatus(String status);
}
