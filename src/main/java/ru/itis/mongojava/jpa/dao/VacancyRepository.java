package ru.itis.mongojava.jpa.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.mongojava.jpa.models.Company;
import ru.itis.mongojava.jpa.models.Vacancy;

import java.util.List;
import java.util.Optional;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {

    List<Vacancy> findByCompany(Company company);

    Optional<Vacancy> findByTitle(String title);
}
