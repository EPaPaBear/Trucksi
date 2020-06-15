package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ReviewDTO;
import it.contrader.model.Review;
@Component

public class ReviewConverter extends AbstractConverter<Review, ReviewDTO> {
	@Override
	public Review toEntity(ReviewDTO reviewDTO) {
		Review review = null;
		if (reviewDTO != null) {
			review = new Review(reviewDTO.getId(), reviewDTO.getStars(), reviewDTO.getComment());
		}
		return review;
	}

	@Override
	public ReviewDTO toDTO(Review review) {
		ReviewDTO reviewDTO = null;
		if (review != null) {
			reviewDTO = new ReviewDTO(review.getId(), review.getStars(), review.getComment());

		}
		return reviewDTO;
	}
}
