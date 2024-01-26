package ru.dzolotarev.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dzolotarev.springbootapi.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntityByAge(Integer age); // JPA Query case (SELECT * FROM users WHERE age=?)

    @Query("SELECT u FROM UserEntity u ORDER BY u.age DESC") // HQL Query
    List<UserEntity> findAllAndOrderByAgeDesc();
}
