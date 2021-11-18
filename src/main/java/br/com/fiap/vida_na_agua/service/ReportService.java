package br.com.fiap.vida_na_agua.service;

import br.com.fiap.vida_na_agua.model.Report;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReportService {

    public List<Report> getAll();
    public Optional<List<Report>> listByName(String name);
    public Optional<List<Report>> listByStateAndYear(String state, int year);
    public Optional<Report> getById(ObjectId id);
    public Optional<Report> create(Report report);
    public Optional<Report> update(ObjectId id, Report report);
    public void delete(ObjectId id);


}
