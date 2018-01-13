package br.com.testweb.classes;

import java.util.Date;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class Motorista {

    private int id;
    private String nome;
    private Date dt_nascimento;
    private String cpf;
    private String modelo_carro;
    private String sexo;
    private boolean status;

    public Motorista() {
    }

    public Motorista(String nome, Date dt_nascimento, String cpf, String modelo_carro, String sexo, boolean status) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.cpf = cpf;
        this.modelo_carro = modelo_carro;
        this.sexo = sexo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getModelo_carro() {
        return modelo_carro;
    }

    public void setModelo_carro(String modelo_carro) {
        this.modelo_carro = modelo_carro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
