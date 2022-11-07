package com.rama.student.service;

import com.rama.student.model.Student;
import com.rama.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
         studentRepository.deleteById(id);
    }



    String keycloakurl =  "http://localhost:8080/realms/student-realm/protocol/openid-connect/token";

    public String getToken(String username, String password) {
        String url = keycloakurl;
        String token = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("client_id","student-restapp");
        map.add("client_secret","1YQ6vZ4FfLbIeFDcs5ey3rarQ7cT7ueJ");
        map.add("username",username);
        map.add("password",password);
        map.add("grant_type","password");
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(map,headers);
        try{
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST,entity,String.class);
            System.out.println("response"+response.getBody());
            token=response.getBody();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }
}
