package br.com.fiap.vida_na_agua.service;

import br.com.fiap.vida_na_agua.model.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MappingService {

    public List<Mapping> list();
    public Optional<Mapping> create(Mapping mapping);
    public void delete(String name);
}
