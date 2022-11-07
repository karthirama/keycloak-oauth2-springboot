package com.rama.student.controller;

import com.rama.student.model.Student;
import com.rama.student.service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createstudent")
    public Student createStudent(Student student){
        return studentService.saveStudent(student);
    }

    @SecurityRequirement(name="Bearer Authentication")
    @GetMapping("getstudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("getstudentbyid/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("updatestudent")
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("deletestudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/getToken/{username}/{password}")
    public ResponseEntity<String> getToken(@PathVariable String username,@PathVariable String password){
        String response = studentService.getToken(username,password);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
