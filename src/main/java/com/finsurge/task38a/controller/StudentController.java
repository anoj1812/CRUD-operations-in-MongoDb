package com.finsurge.task38a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finsurge.task38a.model.Student;
import com.finsurge.task38a.repository.StudentRepository;
import com.finsurge.task38a.service.SequenceGeneratorService;

@RestController
public class StudentController extends Exception{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/students")
    public List < Student > getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity < Student > getStudentById(@PathVariable(value = "id") Long studentId){
        Student student = studentRepository.findById(studentId).get();
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        student.setId(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME));
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity < Student > updateStudent(@PathVariable(value = "id") Long studentId,
                                                    @RequestBody Student studentDetails){
        Student student = studentRepository.findById(studentId).get();
        student.setStudentClg(studentDetails.getStudentClg());
        student.setStudentDept(studentDetails.getStudentDept());
        student.setStudentName(studentDetails.getStudentName());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") Long studentId)
    {
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return ResponseEntity.ok("Deleted successfully");
    }
}

