package com.example.demo.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserEntity;

import aj.org.objectweb.asm.Type;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {
//extends CrudRepository<UserEntity, Long>

	// SQL> SELECT COUNT(*) FROM USER_TABLE WHERE USER_EMAIL='sandy@gmail.com' AND
	// USER_PASSWORD='Sandeepkumaryadav';

	@Query(value = "select count(*) from USER_TABLE_NEW u  WHERE u.USER_EMAIL= ? AND u.USER_PASSWORD= ?", nativeQuery = true)
	int checkValidation(String email, String password);

	@Query(value = "select * from USER_TABLE_NEW u where u.user_id=?",nativeQuery = true)
	UserEntity fatchById(Integer userid);
	
	@Query(value ="select u from UserEntity u where u.active=true")
	public Page<UserEntity> findAllAfterSoftDeletion(PageRequest page);
	
	@Query(value ="update UserEntity u set u.active='FALSE' where u.userid=:id")
	@Modifying
	@Transactional
	public void softDeleteById(int id);
	
	 
}
