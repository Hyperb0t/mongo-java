package ru.itis.mongojava.spring;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.itis.mongojava.spring.models.Person;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleMongoConfig.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);
        Person person = Person.builder().name("Владислав Спрингов")
                .age(33)
                .skills(Arrays.asList("spring", "java"))
                .email("springme@gmail.com")
                .build();

//        template.save(person);


//        db.person.find( { $or: [ {skills: "java"}, {skills: "react"} ] } );
        List<Person> personList = template.find(
                new Query(Criteria.where("").
                        orOperator(
                                where("skills").is("java"),
                                where("skills").is("react"))),
                Person.class, "person"
        );

        System.out.println(personList);

    }
}
