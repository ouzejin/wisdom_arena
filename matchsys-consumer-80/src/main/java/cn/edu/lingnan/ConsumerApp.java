package cn.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: match-system
 * @description: RUN
 * @author: Ouzj
 * @create: 2020-06-16 16:44
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
