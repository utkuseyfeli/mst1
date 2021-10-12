package com.example.mst1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Teacher {

    @Id
    @GeneratedValue
    private String id;// açıklama studentta

    private String name;
    private String surname;

//    private List<Lesson> lessons;
    private List<String> lessonIds;
}
