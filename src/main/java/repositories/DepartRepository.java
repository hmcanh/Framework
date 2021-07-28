package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Depart;

@Repository
public interface DepartRepository  extends CrudRepository<Depart, Integer> {

}
