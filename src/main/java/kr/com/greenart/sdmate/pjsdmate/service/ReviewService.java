package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Review;
import kr.com.greenart.sdmate.pjsdmate.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review getReviewByNo(int reviewNo) {
        Review review = reviewRepository.findByReviewNo(reviewNo).get();
        return review;
    }

    public int getReviewCnt(int plannerNo) {
        return reviewRepository.countByplannerNo(plannerNo);
    }
}
