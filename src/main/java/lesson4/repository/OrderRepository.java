package lesson4.repository;


import lesson4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository <Order, UUID> {
}
