package ru.dzolotarev.springbootapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users", schema = "spring")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
}
