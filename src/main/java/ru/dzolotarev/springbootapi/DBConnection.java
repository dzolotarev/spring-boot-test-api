package ru.dzolotarev.springbootapi;

import org.springframework.beans.factory.annotation.Value;

public class DBConnection {
    @Value("${login}")
    private String login;

    @Value("${password}")
    private Integer password;
}
