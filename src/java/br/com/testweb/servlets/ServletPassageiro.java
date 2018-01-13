package br.com.testweb.servlets;

import br.com.testweb.classes.Passageiro;
import br.com.testweb.services.ServicePassageiro;
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
public class ServletPassageiro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/cadastrar_passageiro":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar_passageiro.jsp");
                rd.forward(request, response);
                break;
            case "/editar_passageiro":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/editar_passageiro.jsp");
                rd.forward(request, response);
                break;
            case "/listar_passageiros":
                List passageiros = ServicePassageiro.listar();

                if (passageiros != null) {
                    request.setAttribute("passageiros", passageiros);
                } else {
                    request.setAttribute("msgErro", "Sua busca não gerou resultados!");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/listar_passageiros.jsp");
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

        Passageiro passageiro;
        Integer passageiroID;

        switch (context) {
            case "/passageiro_cadastrar":
                passageiro = new Passageiro();

                passageiro.setNome(request.getParameter("nome_completo"));
                passageiro.setCpf(request.getParameter("cpf"));
                passageiro.setSexo(request.getParameter("sexo"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    passageiro.setDt_nascimento(new Date(sdf.parse(request.getParameter("dt_nascimento")).getTime()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                if (ServicePassageiro.cadastrar(passageiro)) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/passageiro_atualizar":
                passageiro = new Passageiro();

                passageiro.setId(Integer.parseInt(request.getParameter("id")));
                passageiro.setNome(request.getParameter("nome_completo"));
                passageiro.setCpf(request.getParameter("cpf"));
                passageiro.setSexo(request.getParameter("sexo"));
                sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    passageiro.setDt_nascimento(new Date(sdf.parse(request.getParameter("dt_nascimento")).getTime()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                if (ServicePassageiro.atualizar(passageiro)) {
                    response.sendRedirect(request.getContextPath() + "/success");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "/passageiro_alterar":
                passageiroID = Integer.parseInt(request.getParameter("id"));

                passageiro = ServicePassageiro.obter(passageiroID);

                if (passageiro != null) {
                    request.setAttribute("passageiro", passageiro);
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }

                rd = request.getRequestDispatcher("/WEB-INF/jsp/editar_passageiro.jsp");
                rd.forward(request, response);
                break;
            case "/passageiro_excluir":
                passageiroID = Integer.parseInt(request.getParameter("id"));

                boolean resp = ServicePassageiro.excluir(passageiroID);

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
