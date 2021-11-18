package br.com.fiap.vida_na_agua.service.impl;

import br.com.fiap.vida_na_agua.model.Report;
import br.com.fiap.vida_na_agua.repository.ReportsRepository;
import br.com.fiap.vida_na_agua.service.ReportService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportsRepository reportsRepository;

    @Override
    public List<Report> getAll() {
        return this.reportsRepository.findAll();
    }

    @Override
    public Optional<List<Report>> listByName(String name) {
        return this.reportsRepository.findByName(name);
    }

    @Override
    public Optional<List<Report>> listByStateAndYear(String state, int year) {
        return this.reportsRepository.findByStateAndYear(state, year);
    }

    @Override
    public Optional<Report> getById(ObjectId id) {
        return this.reportsRepository.findById(id);
    }

    @Override
    public Optional<Report> create(Report report) {
        try {
            Optional<Report> reportsSaved = this.reportsRepository.findByNameAndYear(report.getName().toLowerCase(), report.getYear());
            if (reportsSaved.isEmpty()) {
                report.set_id(ObjectId.get());
                return Optional.of(this.reportsRepository.save(reportPreSave(report)));
            }
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Report> update(ObjectId id, Report report) {
        Optional<Report> resultadoResponse = this.reportsRepository.findById(id);
        if (resultadoResponse.isEmpty()) {
            return Optional.empty();
        }
        report.set_id(id);
        return Optional.of(this.reportsRepository.save(reportPreSave(report)));
    }

    @Override
    public void delete(ObjectId id) {
        this.reportsRepository.deleteById(id);
    }

    private Report reportPreSave(Report report) {
        report.setName(report.getName().toLowerCase());
        report.setState(report.getState().toLowerCase());
        return report;
    }
}
