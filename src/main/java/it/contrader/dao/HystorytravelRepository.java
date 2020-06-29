package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;


@Repository
@Transactional
@Primary

public interface HystorytravelRepository extends CrudRepository<Hystorytravel, Long> {

	
}