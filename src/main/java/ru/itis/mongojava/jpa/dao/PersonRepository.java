package ru.itis.mongojava.jpa.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.mongojava.jpa.models.Person;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query(value = "{skills: ?skill}")
    List<Person> findWithSkill(@Param("skill")String skill);

    List<Person> findBySkillsIn(List<String> skills);
}
