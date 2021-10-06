package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao{
    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession sessao = req.getSession();

        //invalidando a sessao inteira
        sessao.invalidate();

        return "redirect:entrada?acao=LoginForm";
    }
}
