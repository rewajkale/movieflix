package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> Users = query.getResultList();
		if (Users != null && Users.size() == 1) {
			return Users.get(0);
		}
		return null;
	}

	@Override
	public User create(User emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public User update(User emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(User emp) {
		em.remove(emp);
	}
}
