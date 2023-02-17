package com.example.gira.service;

import com.example.gira.model.Classification;
import com.example.gira.model.enums.ClassificaionName;
import com.example.gira.repository.ClassificationRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClassificationService {
    private final ClassificationRepo classificationRepo;

    public ClassificationService(ClassificationRepo classificationRepo) {
        this.classificationRepo = classificationRepo;
    }

    public void initClassificationsDB() {
        if (this.classificationRepo.count() == 0) {
            List<Classification> moodList = Arrays.stream(ClassificaionName.values())
                    .map(classificaion -> new Classification().setName(classificaion))
                    .toList();

            this.classificationRepo.saveAll(moodList);
        }
    }

    public Classification findByName(ClassificaionName name) {
        return this.classificationRepo.findByName(name);
    }
}
