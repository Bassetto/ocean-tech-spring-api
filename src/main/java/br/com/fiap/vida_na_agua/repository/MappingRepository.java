package br.com.fiap.vida_na_agua.repository;

import br.com.fiap.vida_na_agua.model.Mapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MappingRepository extends MongoRepository<Mapping, String> {
}
