package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ControladorFilter")
public class ControladorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        //a referencia servletRequest aponta para um HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

        /*
            IMPLEMENTANDO O PATTERN REFLECTION

            O Reflection, em poucas palavras, serve para determinar métodos e atributos
            que serão utilizados de determinada classe (que você nem conhece) em tempo de execução.
         */
        String nome;
        try {
            //CRIANDO CLASSE GENÉRICA BASEADO NO NOME DA CLASSE
            Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome da string (é um autoload)

            //CRIANDO INSTANCIA DA CLASSE GENÉRICA
            Object obj = classe.newInstance();

            //transformando pra específica
            Acao acao = (Acao) obj;

            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] tipoEndereco = nome.split(":");
        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);
        }
    }
}
