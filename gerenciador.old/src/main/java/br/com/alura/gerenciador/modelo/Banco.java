package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    //simulando a adicao de uma chave primeira do banco
    private static Integer ChaveSequencial = 1;

    //simulando a base
    static {
        Empresa empresa = new Empresa();
        empresa.setNome("teste");
        empresa.setId(ChaveSequencial++);
        empresas.add(empresa);

        Usuario u1 = new Usuario();
        u1.setLogin("Lucas");
        u1.setSenha("1234");

        Usuario u2 = new Usuario();
        u2.setLogin("teste");
        u2.setSenha("1234");

        usuarios.add(u1);
        usuarios.add(u2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.ChaveSequencial++);
        empresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        //assim que se usa atributos estáticos
        return Banco.empresas;
    }

    public void removeEmpresa(Integer id) {

        Iterator<Empresa> it = empresas.iterator();

        //verificando se há outro elemento na lista
        while(it.hasNext()) {
            //pegando o próximo elemento da lista
            Empresa emp = it.next();

            if(emp.getId() == id) {
                //ele já sabe qual é a posição
                it.remove();
            }
        }
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
        for (Empresa empresa : empresas) {
            if(empresa.getId() == id) {
                return empresa;
            }
        }

        return null;
    }

    public Usuario existeUsuario(String login, String senha) {
        for(Usuario usuario : usuarios) {
            if (usuario.ehIgual(login, senha)) {
                return usuario;
            }
        }

        return null;
    }
}
