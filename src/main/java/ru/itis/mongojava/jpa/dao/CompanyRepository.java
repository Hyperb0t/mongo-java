package ru.itis.mongojava.jpa.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.mongojava.jpa.models.Company;

import java.util.Optional;

public interface CompanyRepository extends MongoRepository<Company, String> {

    Optional<Company> findByName(String name);
}
