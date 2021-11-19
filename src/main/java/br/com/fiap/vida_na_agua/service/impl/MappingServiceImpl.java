package br.com.fiap.vida_na_agua.service.impl;

import br.com.fiap.vida_na_agua.model.Mapping;
import br.com.fiap.vida_na_agua.repository.MappingRepository;
import br.com.fiap.vida_na_agua.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingServiceImpl implements MappingService {

    @Autowired
    MappingRepository mappingRepository;

    @Override
    public List<Mapping> list() {
        try {
            return mappingRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Mapping> create(Mapping mapping) {
        try {
            return Optional.of(this.mappingRepository.save(mapping));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(String name) {
        try {
            this.mappingRepository.deleteById(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
