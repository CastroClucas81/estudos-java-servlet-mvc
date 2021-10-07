package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//servlet e acao são os controllers
public interface Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
