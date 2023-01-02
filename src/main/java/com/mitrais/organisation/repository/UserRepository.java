package com.mitrais.organisation.repository;

import com.mitrais.organisation.repository.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByName(String name);

    Optional<User> findById(String id);

    User save(User entity);

    void deleteById(String id);
}
