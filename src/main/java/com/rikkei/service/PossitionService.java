package com.rikkei.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rikkei.entity.Position;
import com.rikkei.repository.IPossitionRepository;
@Service
public class PossitionService implements IPossitionService {
@Autowired
private IPossitionRepository possitionRepository;
@Override
public List<Position> getAllPossition() {
// TODO Auto-generated method stub
return possitionRepository.findAll();
}
}