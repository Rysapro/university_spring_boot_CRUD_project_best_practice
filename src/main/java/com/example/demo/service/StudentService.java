package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setPhone(studentDetails.getPhone());
        student.setYearOfBirth(student.getYearOfBirth());
        student.setFaculty(student.getFaculty());
        return studentRepository.save(student);
    }
}
