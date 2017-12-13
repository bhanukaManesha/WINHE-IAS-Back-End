package com.winhe.institute.management.session;

import org.springframework.data.repository.CrudRepository;


public interface SessionRepository extends CrudRepository<Session,Long>{

	public Session findByToken(String token);
}
