package br.com.testweb.servlets;

import br.com.testweb.classes.Corrida;
import br.com.testweb.services.ServiceCorrida;
import br.com.testweb.services.ServiceMotorista;
import br.com.testweb.services.ServicePassageiro;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServletCorrida extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/cadastrar_corrida":
                request.setAttribute("passageiros", ServicePassageiro.listar());
                request.setAttribute("motoristas", ServiceMotorista.listar());

                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar_corrida.jsp");
                rd.forward(request, response);
                break;
            case "/listar_corridas":
                request.setAttribute("corridas", ServiceCorrida.listar());

                rd = request.getRequestDispatcher("/WEB-INF/jsp/listar_corridas.jsp");
                rd.forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();

        switch (context) {
            case "/corrida_cadastrar":
                Corrida corrida = new Corrida();
                
                corrida.setMotorista(ServiceMotorista.obter(
                        Integer.parseInt(request.getParameter("motorista"))));
                corrida.setPassageiro(ServicePassageiro.obter(
                        Integer.parseInt(request.getParameter("passageiro"))));
                corrida.setValor(Double.parseDouble(request.getParameter("valor")));
                
                if (ServiceCorrida.cadastrar(corrida)) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }                
                break;            
            default:
                break;
        }
    }
}
