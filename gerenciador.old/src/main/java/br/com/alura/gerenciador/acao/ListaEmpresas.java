package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao {

    //IMPLEMENTACAO DO PATTERN COMMAND
    //NAO É UM SERVLET
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pegando banco
        Banco banco = new Banco();

        // pegando empresas
        List<Empresa> lista = banco.getEmpresas();

        // passando um atributo pela requisicao para o jsp
        request.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
