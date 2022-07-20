package com.example.dataUpload.repository;

import com.example.dataUpload.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KimShinyeong
 */
public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
