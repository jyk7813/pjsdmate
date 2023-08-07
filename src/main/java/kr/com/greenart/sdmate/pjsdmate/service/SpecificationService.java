package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;

public class SpecificationService {
    private final SpecificationRepository specificationRepository;


    public SpecificationService(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }
}
