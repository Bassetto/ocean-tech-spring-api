package br.com.fiap.vida_na_agua.repository;

import br.com.fiap.vida_na_agua.model.Report;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportsRepository extends MongoRepository<Report, ObjectId> {

    @Query("{name: ?0}")
    Optional<List<Report>> findByName(String name);

    @Query("{name: ?0, year: ?1}")
    Optional<Report> findByNameAndYear(String name, int year);

    @Query("{state: ?0, year: ?1}")
    Optional<List<Report>> findByStateAndYear(String state, int year);

}
