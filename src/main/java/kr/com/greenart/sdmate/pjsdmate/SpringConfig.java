package kr.com.greenart.sdmate.pjsdmate;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.*;
import kr.com.greenart.sdmate.pjsdmate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Configuration

public class SpringConfig {
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    // 서비스 객체들 bean
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public PlannerService plannerService(){
        return new PlannerService(plannerRepository());
    }
    @Bean
    public RequirementService requirementService(){
        return new RequirementService(requirementRepository());
    }
    @Bean
    public ReviewService reviewService(){
        return new ReviewService(reviewRepository());
    }
    @Bean
    public SpecificationService specificationService(){
        return new SpecificationService(specificationRepository());
    }

    //repository 객체 bean
    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
    @Bean
    public PlannerRepository plannerRepository(){
        return new JpaPlannerRepository(em);
    }
    @Bean
    public RequirementRepository requirementRepository(){
        return new JpaRequirementRepository(em);
    }
    @Bean
    public ReviewRepository reviewRepository(){
        return new JpaReviewRepository(em);
    }
    @Bean
    public SpecificationRepository specificationRepository(){
        return new JpaSpecificationRepository(em);
    }

}
