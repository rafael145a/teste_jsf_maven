package br.com.peretz.controller;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Endereco;
import br.com.peretz.model.entities.Pessoa;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rafael
 */

@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MbPessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String limpPessoa(){
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }
    
    public String editPessoa(){
        return "/restrict/cadastrarPessoa.faces";
    }
    
    public void addPessoa(){
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0){
            insertPessoa();
        }else{
            updatePessoa();
        }
    }
    
    private void insertPessoa(){
        pessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Gravação Efetuada!!!"));
    }
    
    private void updatePessoa(){
        pessoaDAO().update(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Atualização Efetuada!!!"));
    }
            
    public void deletePessoa(){
        pessoaDAO().delete(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Pessoa deletada!"));
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}
