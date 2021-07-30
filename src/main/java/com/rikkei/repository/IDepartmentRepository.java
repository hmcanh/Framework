package com.rikkei.repository ;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rikkei.entity.Department;
public interface IDepartmentRepository extends JpaRepository<Department, Short> {
public Department findByName(String name);
public boolean existsByName(String name);
}