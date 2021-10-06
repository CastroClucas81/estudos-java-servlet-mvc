package br.com.alura.gerenciador.acao;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlteraEmpresa implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //pegando os parâmetros enviados por url

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        String idEmpresa = req.getParameter("id");
        Integer id = Integer.valueOf(idEmpresa);

        Date dataAbertura = null;
        try {
            //formatando a data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
