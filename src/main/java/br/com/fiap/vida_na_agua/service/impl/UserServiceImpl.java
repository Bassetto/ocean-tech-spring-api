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
        try {
            return this.userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<User> getById(ObjectId id) {
        try {
            return this.userRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try {
            return this.userRepository.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> register(User user) {
        try {
            if (this.userRepository.findByUsername(user.getUsername().toLowerCase()).isEmpty()) {
                user.set_id(ObjectId.get());
                user.setUsername(user.getUsername().toLowerCase());
                User userReturn = this.userRepository.save(user);
                userReturn.setPassword("");
                return Optional.of(userReturn);
            }
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> login(User user) {
        try {
            Optional<User> userSaved = this.userRepository.findByUsername(user.getUsername().toLowerCase());
            if (userSaved.isEmpty()) {
                return Optional.empty();
            }
            User userReturn = userSaved.get();
            if (userReturn.getPassword().equals(user.getPassword())) {
                userReturn.setPassword("");
                return Optional.of(userReturn);
            }
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> update(ObjectId id, User user) {
        try {
            Optional<User> userSaved = this.userRepository.findById(id);
            if (userSaved.isEmpty()) {
                return Optional.empty();
            }
            user.set_id(new ObjectId(userSaved.get().get_id()));
            return Optional.of(this.userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(ObjectId id) {
        try {
            this.userRepository.deleteById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
