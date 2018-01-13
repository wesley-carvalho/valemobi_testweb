package br.com.testweb.validators;

import br.com.testweb.classes.Corrida;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ValidatorCorrida {

    public static void validar(Corrida corrida) {
        if(corrida == null){
            throw new IllegalArgumentException("Não foi informado uma corrida");
        }
        if(corrida.getMotorista() == null){
            throw new IllegalArgumentException("Não foi informado um motorista");
        }
        if(corrida.getPassageiro() == null){
            throw new IllegalArgumentException("Não foi informado um passageiro");
        }
        if(corrida.getValor().isNaN()){
            throw new IllegalArgumentException("Não foi informado um valor");
        }
    }
}
