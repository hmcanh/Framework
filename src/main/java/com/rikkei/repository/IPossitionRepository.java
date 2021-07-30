package com.rikkei.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rikkei.entity.Position;
public interface IPossitionRepository extends JpaRepository<Position, Short>{
}
