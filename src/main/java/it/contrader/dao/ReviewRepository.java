package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Review;

@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Long>{
	Optional<Review> findById(Long id);
}
