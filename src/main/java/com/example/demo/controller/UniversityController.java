package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAllUniversity(){
        return universityService.getAllUniversity();
    }

    @GetMapping("/{id}")
    public Optional<University> getUniversityById(@PathVariable Long id){
        return universityService.findUniversityById(id);
    }

    @PostMapping
    public University addUniversity(@RequestBody University university){
        return universityService.saveUniversity(university);
    }

    @PutMapping("/{id}")
    public University updateUniversity(@PathVariable Long id, @RequestBody University university){
        return universityService.updateUniversity(id, university);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable Long id){
        universityService.deleteUniversity(id);
    }
}
