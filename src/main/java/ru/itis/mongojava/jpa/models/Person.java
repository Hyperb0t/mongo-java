package ru.itis.mongojava.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {

    @Id
    private String _id;

    private String name;
    private List<String> skills;
    private List<String> previousJobs;
    private String linkedIn;
    private String email;
    private String phone;
    private List<String> projects;
    private Integer age;

}
