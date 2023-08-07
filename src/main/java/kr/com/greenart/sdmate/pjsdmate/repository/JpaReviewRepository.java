package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaReviewRepository implements ReviewRepository{
    private final EntityManager em;

    public JpaReviewRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Review save(Review review) {
        return null;
    }

    @Override
    public Optional<Review> findByReview_no(Integer review_no) {
        return Optional.empty();
    }

    @Override
    public List<Review> findAll() {
        return null;
    }
}
