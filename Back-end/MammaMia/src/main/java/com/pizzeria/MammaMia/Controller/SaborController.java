package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.SaborDTO;
import com.pizzeria.MammaMia.Entity.Sabor;
import com.pizzeria.MammaMia.Service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sabor")
public class SaborController {

    @Autowired
    private SaborService service;

    @GetMapping("/findall")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")


    public List<Sabor> Findall() {
        return service.Findall();
    }

    @GetMapping("/nome")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public Sabor findByNome(@RequestParam String nome) {
        return service.findByNome(nome);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGER')")


    public ResponseEntity<Sabor> create (@RequestBody
                                         SaborDTO saborDTO) {
        return service.create(saborDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole( 'MANAGER')")

    public ResponseEntity<Object> update(@RequestBody SaborDTO saborDTO, @RequestParam Long id){
        return service.update(id, saborDTO);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('MANAGER')")

    public ResponseEntity<Object> Delete(@RequestParam long id){

        return service.delete(id);
    }



}
