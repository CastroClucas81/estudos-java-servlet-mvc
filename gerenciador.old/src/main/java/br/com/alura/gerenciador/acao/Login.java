package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("Logando "+ login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login, senha);

        if (usuario != null) {
            //marcando o usuário como "logado".. passei o objeto para ele
            //pegando o session q o java cria pra cada requisicao
            HttpSession sessao = request.getSession();

            //jogando o usuário na sessao
            //assim, o tomcat consegue recuperar dentro de cada requisicao
            //só funciona no mesmo navegador
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresas";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }

    }
}
