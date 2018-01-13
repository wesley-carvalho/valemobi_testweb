package br.com.testweb.services;

import br.com.testweb.classes.Passageiro;
import br.com.testweb.dao.DaoPassageiro;
import br.com.testweb.validators.ValidatorPassageiro;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServicePassageiro {

    public static boolean cadastrar(Passageiro passageiro) {
        try {
            ValidatorPassageiro.validar(passageiro);

            DaoPassageiro.cadastrar(passageiro);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean atualizar(Passageiro passageiro) {
        try {
            ValidatorPassageiro.validar(passageiro);
            
            DaoPassageiro.atualizar(passageiro);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Passageiro> listar() {
        try {
            return DaoPassageiro.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Passageiro obter(int id) {
        try {
            return DaoPassageiro.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoPassageiro.excluir(id);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
