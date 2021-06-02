package com.example.chat.repo;

import com.example.chat.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

   Users findByLogin(String login);
    long count();

    @Override
    void delete(Users users);



}
