package ru.itis.mongojava.spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private List<String> skills;
    private List<String> previousJobs;
    private String linkedIn;
    private String email;
    private String phone;
    private List<String> projects;
    private Integer age;

}
