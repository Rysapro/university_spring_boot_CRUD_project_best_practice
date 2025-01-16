package com.example.demo.service;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty saveFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findFacultyById(Long id){
        return facultyRepository.findById(id);
    }

    public List<Faculty> findAllFaculty(){
        return facultyRepository.findAll();
    }

    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public Faculty updateFaculty(Long id, Faculty facultyDetails){
        Faculty faculty = facultyRepository.findById(id).orElseThrow();
        faculty.setName(facultyDetails.getName());
        return facultyRepository.save(faculty);
    }
}
