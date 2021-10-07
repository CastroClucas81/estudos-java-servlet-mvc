package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//WEBSERVICE
@WebServlet(name = "EmpresasService", value = "/empresas")
public class EmpresasService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empresa> empresas = new Banco().getEmpresas();

        //lendo cabeçalho da requisição
        String valor = request.getHeader("Accept");

        //endsWith refere-se ao final do cabeçalho
        if (valor.endsWith("xml")) {
            //exportando para xml
            XStream xstream = new XStream();
            xstream.alias("empresa", Empresa.class);
            String xml = xstream.toXML(empresas);

            response.setContentType("application/json");
            response.getWriter().print(xml);
        } else if (valor.endsWith("json")) {
            //EXPORTANDO JSON
            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            response.setContentType("application/json");
            response.getWriter().print(json);
        } else {
            response.setContentType("application/json");
            response.getWriter().print("{'message': 'No content.'}");
        }

    }
}
