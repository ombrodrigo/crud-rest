package com.ombrodrigo.crudrest.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ombrodrigo.crudrest.domain.Conta;
import com.ombrodrigo.crudrest.dto.ContaDto;
import com.ombrodrigo.crudrest.services.exception.ObjectNotFoundException;
import com.ombrodrigo.crudrest.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public List<Conta> findAll(int page, int size) {
        return contaRepository.findAll();
    }

    public Conta findById(String id) {
        Optional<Conta> conta = contaRepository.findById(id);

        if (!conta.isPresent()) {
            throw new ObjectNotFoundException("A conta informada não foi localizada.");
        }
        
        return conta.get();
    }

    public Conta insert(ContaDto contaDto) {
        Conta conta = new Conta(
            null,
            contaDto.getNumero(),
            contaDto.getAgencia(),
            contaDto.getCpf(),
            true,
            LocalDateTime.now(),
            null
        );

        return this.insert(conta);
    }

    public Conta insert(Conta conta) {
        return contaRepository.insert(conta);
    }

    public Conta update(ContaDto contaDto) {
        Conta conta = findById(contaDto.getId());
        
        conta.setNumero(contaDto.getNumero());
        conta.setAgencia(contaDto.getAgencia());
        conta.setCpf(contaDto.getCpf());
        conta.setDataAtualizacao(LocalDateTime.now());

        return contaRepository.save(conta);
    }

    public void delete(String id) {
        Conta conta = findById(id);
        
        conta.setStatus(false);
        conta.setDataAtualizacao(LocalDateTime.now());
        
        contaRepository.save(conta);
    }
}