package br.com.testweb.classes;

import java.util.Date;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class Passageiro {

    private int id;
    private String nome;
    private Date dt_nascimento;
    private String cpf;
    private String sexo;

    public Passageiro() {
    }

    public Passageiro(String nome, Date dt_nascimento, String cpf, String sexo) {
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.cpf = cpf;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
