package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//FILTER VEM ANTES DO CONTROLLER
//todas as requisições que chegarem no controller tb passarao por aq antes
@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //MEDIR O TEMPO DE EXECUCAO APLICACAO
        long antes = System.currentTimeMillis();

        String paramAcao = servletRequest.getParameter("acao");

        //executa a acao
        //se ele nao chama o doFilter a requisicao fica parada
        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de execução do " + paramAcao + ": " + (depois - antes));
    }

}
