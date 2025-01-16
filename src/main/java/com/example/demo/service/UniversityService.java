package com.example.demo.service;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University saveUniversity(University university){
        return universityRepository.save(university);
    }

    public Optional<University> findUniversityById(Long id){
        return universityRepository.findById(id);
    }

    public List<University> getAllUniversity(){
        return universityRepository.findAll();
    }

    public void deleteUniversity(Long id){
        universityRepository.deleteById(id);
    }

    public University updateUniversity(Long id, University universityDetails){
        University university = universityRepository.findById(id).orElseThrow();
        university.setName(universityDetails.getName());
        university.setCity(universityDetails.getCity());
        university.setCountry(universityDetails.getCountry());
        university.setAddress(universityDetails.getAddress());
        university.setPhone(universityDetails.getPhone());
        university.setEmail(universityDetails.getEmail());
        return universityRepository.save(university);
    }
}
