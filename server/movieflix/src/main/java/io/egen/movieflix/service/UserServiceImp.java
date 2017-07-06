package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.exception.EntityAlreadyExistsException;
import io.egen.movieflix.exception.EntityNotFoundException;
import io.egen.movieflix.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String id) {
		User existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("User with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User emp) {
		User existing = repository.findByEmail(emp.getEmail());
		if (existing != null) {
			throw new EntityAlreadyExistsException("Email is already in use: " + emp.getEmail());
		}
		return repository.create(emp);
	}

	@Override
	@Transactional
	public User update(String id, User emp) {
		User existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("User with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("User with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
