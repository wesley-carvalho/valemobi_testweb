package br.com.testweb.services;

import br.com.testweb.classes.Corrida;
import br.com.testweb.dao.DaoCorrida;
import br.com.testweb.validators.ValidatorCorrida;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServiceCorrida {
    public static boolean cadastrar(Corrida corrida) {
        try {
            ValidatorCorrida.validar(corrida);
            
            DaoCorrida.cadastrar(corrida);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            
            return false;
        }
    }

    public static List<Corrida> listar() {
        try {
            return DaoCorrida.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
