package ru.itis.mongojava.jpa;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.SpringDataMongoDB;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "ru.itis.mongojava.jpa")
public class RepositoriesConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoDatabaseFactory mongoDbFactory =  new SimpleMongoClientDatabaseFactory(
                MongoClients.create(), "hiring");

        return new MongoTemplate(mongoDbFactory,
                new MappingMongoConverter(
                        new DefaultDbRefResolver(mongoDbFactory),
                        new MongoMappingContext()
                )
        );
//        return new MongoTemplate(MongoClients.create(), "hiring");
    }
}