package org.sesame.ms.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplicationService.class, args);
    }



}
