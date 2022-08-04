package com.outreach.greenstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outreach.greenstar.dto.StudentDTO;
import com.outreach.greenstar.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping(value="/group/{groupId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByGroup(@PathVariable int groupId) {
        List<StudentDTO> studentList = studentService.getStudentsByGroup(groupId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="/section/{secId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsBySection(@PathVariable int secId) {
        List<StudentDTO> studentList = studentService.getStudentsBySection(secId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="/section/no-group/{secId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getAvailableStudentsBySection(@PathVariable int secId) {
        List<StudentDTO> studentList = studentService.getAvailableStudentsBySection(secId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="/class/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByClass(@PathVariable int classId) {
        List<StudentDTO> studentList = studentService.getStudentsByClass(classId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="/class/no-group/{classId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getAvailableStudentsByClass(@PathVariable int classId) {
        List<StudentDTO> studentList = studentService.getAvailableStudentsByClass(classId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="/school/{schoolId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsBySchool(@PathVariable int schoolId) {
        List<StudentDTO> studentList = studentService.getStudentsBySchool(schoolId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    
    @GetMapping(value="{studentId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int studentId) {
        StudentDTO student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
        StudentDTO newStudent = studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }
    
    @PutMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO student) {
        StudentDTO newStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
