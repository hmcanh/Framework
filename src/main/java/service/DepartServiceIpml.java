package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import models.Depart;
import repositories.DepartRepository;
@Service
public class DepartServiceIpml implements DepartService  {
	  @Autowired
	    private DepartRepository departRepository;

	@Override
	public Depart save(Depart entity) {
	        return departRepository.save(entity);
	    }

	    @Override
		public List<Depart> saveAll(List<Depart> entities) {
	        return (List<Depart>) departRepository.saveAll(entities);
	    }


	    @Override
		public Optional<Depart> findById(Integer integer) {
	        return departRepository.findById(integer);
	    }


	    @Override
		public boolean existsById(Integer integer) {
	        return departRepository.existsById(integer);
	    }


	    @Override
		public Iterable<Depart> findAll() {
	        return departRepository.findAll();
	    }


	    @Override
		public List<Depart> findAllById(List<Integer> ids) {
	        return (List<Depart>) departRepository.findAllById(ids);
	    }

	    @Override
		public long count() {
	        return departRepository.count();
	    }


	    @Override
		public void deleteById(Integer id) {
	        departRepository.deleteById(id);
	    }


	    @Override
		public void delete(Depart depart) {
	        departRepository.delete(depart);
	    }


	    @Override
		public void deleteAll(List<Depart> entities) {
	        departRepository.deleteAll(entities);
	    }


	    @Override
		public void deleteAll() {
	        departRepository.deleteAll();
	    }
	}

