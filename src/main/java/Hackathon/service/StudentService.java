package Hackathon.service;


import Hackathon.entity.Student;
import Hackathon.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> browseStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        // Check if the student exists
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " does not exist.");
        }
    }

    public void deactivateStudent(Long studentId) {
        // Check if the student exists
        if (studentRepository.existsById(studentId)) {
            Student student = studentRepository.findById(studentId).orElse(null);
            student.setActive(false);
            studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student with ID " + studentId + " does not exist.");
        }
    }
}
