package se.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.pidev.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}