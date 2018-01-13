package br.com.testweb.servlets;

import br.com.testweb.classes.Motorista;
import br.com.testweb.services.ServiceMotorista;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class ServletMotorista extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/cadastrar_motorista":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar_motorista.jsp");
                rd.forward(request, response);
                break;
            case "/editar_motorista":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/editar_motorista.jsp");
                rd.forward(request, response);
                break;
            case "/listar_motoristas":
                List motoristas = ServiceMotorista.listar();

                if (motoristas != null) {
                    request.setAttribute("motoristas", motoristas);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/listar_motoristas.jsp");
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
        RequestDispatcher rd;

        Motorista motorista;
        Integer motoristaID;

        switch (context) {
            case "/motorista_cadastrar":
                motorista = new Motorista();

                motorista.setNome(request.getParameter("nome_completo"));
                motorista.setCpf(request.getParameter("cpf"));
                motorista.setSexo(request.getParameter("sexo"));
                motorista.setModelo_carro(request.getParameter("modelo_carro"));
                motorista.setStatus((request.getParameter("status").equals("true")));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    motorista.setDt_nascimento(new Date(sdf.parse(request.getParameter("dt_nascimento")).getTime()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                if (ServiceMotorista.cadastrar(motorista)) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/motorista_atualizar":
                motorista = new Motorista();
                
                motorista.setId(Integer.parseInt(request.getParameter("id")));
                motorista.setNome(request.getParameter("nome_completo"));
                motorista.setCpf(request.getParameter("cpf"));
                motorista.setSexo(request.getParameter("sexo"));
                motorista.setModelo_carro(request.getParameter("modelo_carro"));
                motorista.setStatus((request.getParameter("status").equals("true")));
                sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    motorista.setDt_nascimento(new Date(sdf.parse(request.getParameter("dt_nascimento")).getTime()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                if (ServiceMotorista.atualizar(motorista)) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/motorista_alterar":
                motoristaID = Integer.parseInt(request.getParameter("id"));

                motorista = ServiceMotorista.obter(motoristaID);

                if (motorista != null) {
                    request.setAttribute("motorista", motorista);
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/editar_motorista.jsp");
                rd.forward(request, response);
                break;
            case "/motorista_excluir":
                motoristaID = Integer.parseInt(request.getParameter("id"));

                boolean resp = ServiceMotorista.excluir(motoristaID);

                if (resp) {
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
