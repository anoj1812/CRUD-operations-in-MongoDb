package com.finsurge.task38a.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Student")
public class Student {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    @Field(name="student_id")
    private long id;
    @Field(name="student_name")
    private String studentName;
    @Field(name="student_dept")
    private String studentDept;
    @Field(name="student_clg")
    private String studentClg;

    public Student() {

    }

    public Student(String studentName, String studentDept, String studentClg) {
        this.studentName = studentName;
        this.studentDept = studentDept;
        this.studentClg = studentClg;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }
    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getStudentClg() {
        return studentClg;
    }
    public void setStudentClg(String studentClg) {
        this.studentClg = studentClg;
    }

}
