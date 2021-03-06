package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findById(String id);

	public User findByEmail(String email);

	public User create(User emp);

	public User update(User emp);

	public void delete(User emp);
}
