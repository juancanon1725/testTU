package com.project.thinkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.thinkup.model.User;
import java.util.List;

import javax.print.DocFlavor.STRING;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByMail(String mail);
    boolean existsByMail(String mail);
}
