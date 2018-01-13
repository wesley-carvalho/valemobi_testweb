package br.com.testweb.validators;

import br.com.testweb.classes.Motorista;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ValidatorMotorista {
    public static void validar(Motorista motorista){
        if(motorista == null){
            throw new IllegalArgumentException("Não foi informado um motorista");
        }
        if(motorista.getNome().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um nome");
        }
        if(motorista.getCpf().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um cpf");
        }
        if(motorista.getDt_nascimento().toString().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um data de nascimento");
        }   
        if(motorista.getSexo().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um sexo");
        }        
    }
}
