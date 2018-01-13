package br.com.testweb.classes;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class Corrida {

    private int id;
    private Motorista motorista;
    private Passageiro passageiro;
    private Double valor;

    public Corrida() {
    }

    public Corrida(Motorista motorista, Passageiro passageiro, Double valor) {
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
