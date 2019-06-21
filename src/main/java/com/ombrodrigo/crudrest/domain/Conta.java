package com.ombrodrigo.crudrest.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Conta implements Serializable {
        
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    private String numero;
    private String agencia;
    private String cpf;
    private Boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Conta(
        String id,
        String numero,
        String agencia,
        String cpf,
        Boolean status,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
    ) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.cpf = cpf;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}