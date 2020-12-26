package ru.itis.mongojava.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.mongojava.jpa.dao.CompanyRepository;
import ru.itis.mongojava.jpa.dao.PersonRepository;
import ru.itis.mongojava.jpa.dao.VacancyRepository;
import ru.itis.mongojava.jpa.models.Company;
import ru.itis.mongojava.jpa.models.Vacancy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoriesConfig.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
        VacancyRepository vacancyRepository = context.getBean(VacancyRepository.class);

        personRepository.findWithSkill("менеджмент").forEach(System.out::println);
        personRepository.findBySkillsIn(Arrays.asList("java", "spring")).forEach(System.out::println);
        System.out.println();

        Vacancy vacancy = vacancyRepository.findByTitle("Погромист").orElse(new Vacancy());
        System.out.println(vacancy.getCompany());

        System.out.println(companyRepository.findById(vacancy.getCompany().toString()));
    }
}
