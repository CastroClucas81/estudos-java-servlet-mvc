package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//POSSO CRIAR UMA CADEIA DE FILTROS
@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        //a referencia servletRequest aponta para um HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        HttpSession sessao = request.getSession();
        boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
        boolean AcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (AcaoProtegida && usuarioNaoEstaLogado) {
            response.sendRedirect("entrada?acao=LoginForm");
            //para o método abruptamente
            return;
        }
        
        chain.doFilter(request, response);
    }
}
