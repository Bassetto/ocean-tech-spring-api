package br.com.fiap.vida_na_agua.service;

import br.com.fiap.vida_na_agua.model.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public List<User> listAll();
    public Optional<User> register(User user);
    public Optional<User> login(User user);
    public Optional<User> getById(ObjectId id);
    public Optional<User> getByUsername(String username);
    public Optional<User> update(ObjectId id, User user);
    public void delete(ObjectId id);
}
