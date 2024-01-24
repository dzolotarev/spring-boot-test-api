package ru.dzolotarev.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dzolotarev.springbootapi.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntityByAge(Integer age); // SELECT * FROM users WHERE age=?

}
