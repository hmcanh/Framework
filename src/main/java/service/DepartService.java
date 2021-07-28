package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import models.Depart;

@Service
public interface DepartService {

	void deleteAll();

	void deleteAll(List<Depart> entities);

	void delete(Depart depart);

	void deleteById(Integer id);

	long count();

	List<Depart> findAllById(List<Integer> ids);

	Iterable<Depart> findAll();

	boolean existsById(Integer integer);

	Optional<Depart> findById(Integer integer);

	List<Depart> saveAll(List<Depart> entities);

	Depart save(Depart entity);
}
