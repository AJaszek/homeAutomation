/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.Home;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Arek
 */
@Controller
public class SendController {

    @Autowired
    Repository repository;

    @GetMapping("/czyJest")
    public @ResponseBody
    String checkIfAtHome() {
        if (repository.findById(1).get().getIsAtHome() == 1) {
            return "<h1>Jest</h1>";
        } else {
            return "<h1>Nie ma</h1>";
        }

    }

    @PutMapping("/czyJest/put")
    public @ResponseBody Home updateHome(@RequestBody Map<String, Object> body) {
        return repository.findById(1).map(home -> {
            home.setIsAtHome(Integer.parseInt(body.get("jest").toString()));
            return repository.save(home);
        })
                .orElseGet(() -> {
                    Home home = new Home();
                    home.setId(1);
                    home.setIsAtHome(Integer.parseInt(body.get("jest").toString()));
                    return repository.save(home);
                });
    }

}
