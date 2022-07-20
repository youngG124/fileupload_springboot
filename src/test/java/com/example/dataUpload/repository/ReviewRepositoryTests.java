package com.example.dataUpload.repository;

import com.example.dataUpload.entity.Member;
import com.example.dataUpload.entity.Movie;
import com.example.dataUpload.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author KimShinyeong
 */

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMovieReviews() {

        IntStream.rangeClosed(1,200).forEach(i -> {

            Long mno = (long)(Math.random()*100) + 101;

            Long mid = ((long)(Math.random()*100) + 1);
            Member member = Member.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int)(Math.random()*5) + 1)
                    .text("I think this movie is..." + i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

    @Test
    public void testGetMovieReviews() {

        Movie movie = Movie.builder().mno(94L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {

            System.out.println(movieReview.getReviewnum());
            System.out.println("\t 평점 : " + movieReview.getGrade());
            System.out.println("\t 리뷰 : " + movieReview.getText());
            System.out.println("\t 아이디 : " + movieReview.getMember().getEmail());
            System.out.println("-------------------------------");
        });
    }
}
