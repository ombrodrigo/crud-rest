package com.ombrodrigo.crudrest.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.ombrodrigo.crudrest.domain.Conta;
import com.ombrodrigo.crudrest.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {

        contaRepository.deleteAll();

        Conta conta1 = new Conta(null, "000001", "0001", "00000000001", true, LocalDateTime.now(), null);
        Conta conta2 = new Conta(null, "000002", "0002", "00000000002", true, LocalDateTime.now(), null);
        Conta conta3 = new Conta(null, "000003", "0003", "00000000003", true, LocalDateTime.now(), null);
        Conta conta4 = new Conta(null, "000004", "0004", "00000000004", true, LocalDateTime.now(), null);
        Conta conta5 = new Conta(null, "000005", "0005", "00000000005", true, LocalDateTime.now(), null);
        Conta conta6 = new Conta(null, "000006", "0006", "00000000006", true, LocalDateTime.now(), null);
        Conta conta7 = new Conta(null, "000007", "0007", "00000000007", true, LocalDateTime.now(), null);
        Conta conta8 = new Conta(null, "000008", "0008", "00000000008", true, LocalDateTime.now(), null);
        Conta conta9 = new Conta(null, "000009", "0009", "00000000009", true, LocalDateTime.now(), null);
        Conta conta10 = new Conta(null, "000010", "0010", "00000000010", true, LocalDateTime.now(), null);

        contaRepository.saveAll(
            Arrays.asList(
                conta1,
                conta2,
                conta3,
                conta4,
                conta5,
                conta6,
                conta7,
                conta8,
                conta9,
                conta10
            )
        );
    }    
}