package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//CONTROLADOR
//@WebServlet(name = "entrada", value = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    //criando um porteiro para as rotas
    // CONTROLADOR
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        /*
        old...

        String nome = null;
        if(paramAcao.equals("listaEmpresas")) {
            ListaEmpresas acao = new ListaEmpresas();
            nome = acao.executa(request, response);

        } else if(paramAcao.equals("removeEmpresa")) {
            RemoveEmpresa acao = new RemoveEmpresa();
            nome = acao.executa(request, response);

        }  else if(paramAcao.equals("mostraEmpresa")) {
            MostraEmpresa acao = new MostraEmpresa();
            nome = acao.executa(request, response);

        }  else if(paramAcao.equals("alteraEmpresa")) {
           AlteraEmpresa acao = new AlteraEmpresa();
           nome = acao.executa(request, response);

        }  else if(paramAcao.equals("novaEmpresa")) {
            NovaEmpresa acao = new NovaEmpresa();
            nome = acao.executa(request, response);

        }  else if(paramAcao.equals("novaEmpresaForm")) {
            NovaEmpresaForm acao = new NovaEmpresaForm();
            nome = acao.executa(request, response);

        }
        */
    }
}
