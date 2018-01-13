package br.com.testweb.services;

import br.com.testweb.classes.Motorista;
import br.com.testweb.dao.DaoMotorista;
import br.com.testweb.validators.ValidatorMotorista;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServiceMotorista {

    public static boolean cadastrar(Motorista motorista) {
        try {
            ValidatorMotorista.validar(motorista);
            
            DaoMotorista.cadastrar(motorista);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean atualizar(Motorista motorista) {
        try {
            ValidatorMotorista.validar(motorista);
            
            DaoMotorista.atualizar(motorista);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Motorista> listar() {
        try {
            return DaoMotorista.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Motorista obter(int id) {
        try {
            return DaoMotorista.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean excluir(int id) {
        try {
            DaoMotorista.excluir(id);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
