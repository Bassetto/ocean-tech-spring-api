package br.com.fiap.vida_na_agua.controller;

import br.com.fiap.vida_na_agua.model.Report;
import br.com.fiap.vida_na_agua.model.User;
import br.com.fiap.vida_na_agua.service.ReportService;
import br.com.fiap.vida_na_agua.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/reports/list")
    public List<Report> listReports() {
        return this.reportService.getAll();
    }

    @GetMapping("/reports/listByName/{name}")
    public ResponseEntity<List<Report>> getReportByName(@PathVariable String name) {
        Optional<List<Report>> resultadoResponse = this.reportService.listByName(name);
        if (resultadoResponse.isEmpty()) {
            return new ResponseEntity<List<Report>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Report>>(resultadoResponse.get(), HttpStatus.OK);
    }

    @GetMapping("/reports/listByStateAndYear/{state}/{year}")
    public ResponseEntity<List<Report>> listReportByStateAndYear(@PathVariable String state, @PathVariable int year) {
        Optional<List<Report>> resultadoResponse = this.reportService.listByStateAndYear(state, year);
        if (resultadoResponse.isEmpty()) {
            return new ResponseEntity<List<Report>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Report>>(resultadoResponse.get(), HttpStatus.OK);
    }

    @GetMapping("/reports/getById/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable ObjectId id) {
        Optional<Report> resultadoResponse = this.reportService.getById(id);
        if (resultadoResponse.isEmpty()) {
            return new ResponseEntity<Report>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Report>(resultadoResponse.get(), HttpStatus.OK);
    }

    @PostMapping("/reports/create")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Optional<Report> resultadoCreated = this.reportService.create(report);
        if (resultadoCreated.isEmpty()) {
            return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Report>(resultadoCreated.get(), HttpStatus.CREATED);
    }

    @PutMapping("/reports/update/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable ObjectId id, @RequestBody Report report) {
        Optional<Report> resultadoResponse = this.reportService.update(id, report);
        if (resultadoResponse.isEmpty()) {
            return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Report>(resultadoResponse.get(), HttpStatus.OK);
    }

    @DeleteMapping("/reports/delete/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable ObjectId id) {
        this.reportService.delete(id);
        return new ResponseEntity<String>("Relatório excluido com sucesso", HttpStatus.OK);
    }

    @GetMapping("/users/list")
    public ResponseEntity<List<User>> listUsers() {
        return new ResponseEntity<List<User>>(this.userService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/users/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ObjectId id) {
        Optional<User> user = this.userService.getById(id);
        if (user.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @PostMapping("/users/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        Optional<User> userSaved = this.userService.register(user);
        if (userSaved.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(userSaved.get(), HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> userLogin = this.userService.login(user);
        if (userLogin.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userLogin.get(), HttpStatus.OK);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody User user) {
        Optional<User> userUpdated = this.userService.update(id, user);
        if (userUpdated.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(userUpdated.get(), HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        this.userService.delete(id);
        return new ResponseEntity<String>("Usuário excluido com sucesso", HttpStatus.OK);
    }
}
