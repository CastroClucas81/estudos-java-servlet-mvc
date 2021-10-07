package br.com.alura.cliente;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ClienteWebService {
    public static void main(String[] args) throws IOException {
        //fazendo uma requisicao
        String conteudo = Request.Post("http://localhost:8080/gerenciador_war_exploded/empresas")
                .addHeader("Accept", "application/json")
                .execute().returnContent()
                .asString();

        System.out.println(conteudo);
    }
}
