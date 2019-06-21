package com.ombrodrigo.crudrest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ombrodrigo.crudrest.domain.Conta;

public class ContaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String id;
    private String numero;
    private String agencia;
    private String cpf;
    private Boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ContaDto() {
        
    }

    public ContaDto(Conta conta) {
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.cpf = conta.getCpf();
        this.status = conta.getStatus();
        this.dataCriacao = conta.getDataCriacao();
        this.dataAtualizacao = conta.getDataAtualizacao();
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