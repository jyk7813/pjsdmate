package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.repository.RequirementRepository;

public class RequirementService {

    private final RequirementRepository requirementRepository;


    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }
}
