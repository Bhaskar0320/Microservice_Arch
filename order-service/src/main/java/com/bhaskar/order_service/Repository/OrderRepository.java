package com.bhaskar.order_service.Repository;

import com.bhaskar.order_service.Model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
