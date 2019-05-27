package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String>{
}
*/
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

//	@Query("select td from User u inner join u.toDoItems td where u = :user")
//	public Iterable<ToDoItem> findAllToDosForLoggedInUser(@Param("user") User user);

//	public User findById(String id);
}