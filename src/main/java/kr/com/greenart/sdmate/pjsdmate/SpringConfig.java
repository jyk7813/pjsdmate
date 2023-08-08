package kr.com.greenart.sdmate.pjsdmate;

import kr.com.greenart.sdmate.pjsdmate.repository.*;
import kr.com.greenart.sdmate.pjsdmate.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SpringConfig {
//    private final MemberRepository memberRepository;
//
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
    ////////////////////////
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 서비스 객체들 bean
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository);
//    }
//    @Bean
//    public PlannerService plannerService(){
//        return new PlannerService(plannerRepository());
//    }
//    @Bean
//    public RequirementService requirementService(){
//        return new RequirementService(requirementRepository());
//    }
//    @Bean
//    public ReviewService reviewService(){
//        return new ReviewService(reviewRepository());
//    }
//    @Bean
//    public SpecificationService specificationService(){
//        return new SpecificationService(specificationRepository());
//    }

    //repository 객체 bean
//
//    @Bean
//    public PlannerRepository plannerRepository(){
//        return new JpaPlannerRepository(em);
//    }
//    @Bean
//    public RequirementRepository requirementRepository(){
//        return new JpaRequirementRepository(em);
//    }
//    @Bean
//    public ReviewRepository reviewRepository(){
//        return new JpaReviewRepository(em);
//    }
//    @Bean
//    public SpecificationRepository specificationRepository(){
//        return new JpaSpecificationRepository(em);
//    }

}
