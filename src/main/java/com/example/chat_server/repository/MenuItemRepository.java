package com.example.chat_server.repository;

import com.example.chat_server.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    MenuItem findByName(String name);
}
