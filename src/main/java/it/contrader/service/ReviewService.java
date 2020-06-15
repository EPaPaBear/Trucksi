package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ReviewConverter;
import it.contrader.dao.ReviewRepository;
import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;
@Service
public class ReviewService extends AbstractService<Review, ReviewDTO> {
	@Autowired
	private ReviewConverter converter;
	@Autowired
	private ReviewRepository repository;
	
	public Review convertReviewDTO(ReviewDTO reviewDTO) {
		return converter.toEntity(reviewDTO);
	}
}
