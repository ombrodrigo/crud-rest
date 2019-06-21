package com.ombrodrigo.crudrest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.ombrodrigo.crudrest.domain.Conta;
import com.ombrodrigo.crudrest.dto.ContaDto;
import com.ombrodrigo.crudrest.services.ContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/conta")
class ContaResource {

    private ContaService contaService;

    @Autowired
    public ContaResource (ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<ContaDto>> findAll() {
        List<ContaDto> listDto = contaService.findAll().stream().map(ContaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDto> findById(@PathVariable String id) {
        Conta conta = contaService.findById(id);
        return ResponseEntity.ok().body(new ContaDto(conta));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ContaDto contaDto) {
        Conta conta = contaService.insert(contaDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ContaDto contaDto, @PathVariable String id) {
        contaDto.setId(id);
        contaService.update(contaDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}