package br.com.fiap.vida_na_agua.service.impl;

import br.com.fiap.vida_na_agua.model.User;
import br.com.fiap.vida_na_agua.repository.UserRepository;
import br.com.fiap.vida_na_agua.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getById(ObjectId id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> register(User user) {
        if (this.userRepository.findByUsername(user.getUsername().toLowerCase()).isEmpty()) {
            user.set_id(ObjectId.get());
            user.setUsername(user.getUsername().toLowerCase());
            return Optional.of(this.userRepository.save(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> login(User user) {
        Optional<User> userSaved = this.userRepository.findByUsername(user.getUsername().toLowerCase());
        if (userSaved.isEmpty()) {
            return Optional.empty();
        }
        if (userSaved.get().getPassword().equals(user.getPassword())) {
            return userSaved;
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> update(ObjectId id, User user) {
        Optional<User> userSaved = this.userRepository.findById(id);
        if (userSaved.isEmpty()) {
            return Optional.empty();
        }
        user.set_id(new ObjectId(userSaved.get().get_id()));
        return Optional.of(this.userRepository.save(user));
    }

    @Override
    public void delete(ObjectId id) {
        this.userRepository.deleteById(id);
    }
}
