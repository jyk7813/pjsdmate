package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Review;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Review save(Review review);

    Optional<Review> findByReviewNo(Integer reviewNo);

    List<Review> findAll();

    @Query("SELECT COUNT(r) FROM Review r WHERE r.planner_no = :plannerNo")
    Integer countByplannerNo(Integer plannerNo);

}
