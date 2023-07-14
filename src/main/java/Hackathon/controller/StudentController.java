package Hackathon.controller;
import Hackathon.entity.Student;
import Hackathon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.browseStudent();
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        student.setId(studentId);
        return studentService.updateStudent(student);
    }

    @PatchMapping("/{studentId}/deactivate")
    public void deactivateStudent(@PathVariable Long studentId) {
        studentService.deactivateStudent(studentId);
    }
}

