package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getFacultyList() {
        return facultyService.findAllFaculty();
    }

    @GetMapping("/{id}")
    public Optional<Faculty> getFaculty(@PathVariable Long id) {
        return facultyService.findFacultyById(id);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails){
        return  facultyService.updateFaculty(id, facultyDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
    }




}
