/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Dao.OrganizacaoDao;
import Modelo.Funcionario;
import Modelo.Organizacao;

/**
 *
 * @author andre
 */
public class teste {
    public static void main(String[] args) {
        Organizacao org = new Organizacao();
        org.setNome("TADS5V DEVELOP");
        org.setCnpj("12334546");
        org.setEndereco("Lagoinha");
        org.setTelefone("084994002431");
        org.setSituacao(true);
        org.setNumeroNivel("12");
        
        //Intancia um objeto ProdutoDAO
        OrganizacaoDao dao = new OrganizacaoDao();
        dao.salvar(org);
    }
}
