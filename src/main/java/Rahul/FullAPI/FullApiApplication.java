package Rahul.FullAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"Controller", "Service", "Repo", "Entity", "Rahul.FullAPI"})
@EntityScan("Entity")
@EnableMongoRepositories(basePackages = "Repo")
public class FullApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FullApiApplication.class, args);
    }
}
