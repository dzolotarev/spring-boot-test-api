package ru.dzolotarev.springbootapi.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ru.dzolotarev.springbootapi.client.ProductClient;

@Configuration
@EnableFeignClients(clients = {ProductClient.class})
public class ClientConfiguration {
}
