package com.rikkei.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rikkei.entity.Department;
import com.rikkei.repository.IDepartmentRepository;
@Service
public class DepartmentService implements IDepartmentService {
@Autowired
private IDepartmentRepository departmentRepository;
public List<Department> getAllDepartments() {
return departmentRepository.findAll();
}
}
