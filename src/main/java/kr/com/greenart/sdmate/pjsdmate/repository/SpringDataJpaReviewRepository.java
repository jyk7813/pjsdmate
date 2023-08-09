package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaReviewRepository extends JpaRepository<Review, Integer>, ReviewRepository {
    @Override
    Optional<Review> findByReviewNo(Integer reviewNo);

    @Override
    Integer countByplannerNo(Integer plannerNo);
}
