package be.kdg.pocticonference.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "be.kdg.pocticonference.repository")
public class AppConfig {
}
