package br.com.testweb.servlets;

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
public class ServletPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String context = request.getServletPath();
        RequestDispatcher rd;

        switch (context) {
            case "/index.html":
            case "/home":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/menu_principal.jsp");
                rd.forward(request, response);
                break;
            case "/success":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
                rd.forward(request, response);
                break;
            case "/error":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                rd.forward(request, response);
                break;
            case "/menu_cadastro_de_corridas":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastro_de_corridas.jsp");
                rd.forward(request, response);
                break;
            case "/menu_cadastro_de_clientes":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastro_de_clientes.jsp");
                rd.forward(request, response);
                break;
            case "/menu_lista_de_clientes":
                rd = request.getRequestDispatcher("/WEB-INF/jsp/lista_de_clientes.jsp");
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

        switch (context) {
            case "/delete":
                request.setAttribute("way", request.getParameter("way"));
                request.setAttribute("id", request.getParameter("id"));

                rd = request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp");
                rd.forward(request, response);
                break;
            default:
                break;
        }
    }
}
