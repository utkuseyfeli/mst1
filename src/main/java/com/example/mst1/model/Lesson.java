package com.example.mst1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Lesson {

    @Id
    @GeneratedValue
    private String lessonId; // Açıklama Student ta
    private String name;
    private int credit;
    private int hours;

    private List<String> teacherIds;
//    private List<Teacher> teacher;
}
