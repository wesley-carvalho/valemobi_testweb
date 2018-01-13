package br.com.testweb.validators;

import br.com.testweb.classes.Passageiro;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ValidatorPassageiro {
    public static void validar(Passageiro passageiro){
        if(passageiro == null){
            throw new IllegalArgumentException("Não foi informado um passageiro");
        }
        if(passageiro.getNome().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um nome");
        }
        if(passageiro.getCpf().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um cpf");
        }
        if(passageiro.getSexo().isEmpty()){
            throw new IllegalArgumentException("Não foi informado um sexo");
        }
        if(passageiro.getDt_nascimento().toString().isEmpty()){
            throw new IllegalArgumentException("Não foi informado uma data de nascimento");
        }
    }
}
