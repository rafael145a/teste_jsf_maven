package br.com.peretz.controller;

import br.com.peretz.conversores.ConverterSHA1;
import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Cidade;
import br.com.peretz.model.entities.Endereco;
import br.com.peretz.model.entities.Estado;
import br.com.peretz.model.entities.Pessoa;
import br.com.peretz.model.entities.TipoEndereco;
import br.com.peretz.model.entities.TipoLogradouro;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Rafael
 */

@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MbPessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private Estado estado = new Estado();
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
        estado = new Estado();
        return editPessoa();
    }
    
    public String editPessoa(){
        return "/restrict/cadastrarPessoa.faces";
    }
    
    public void addPessoa(){
        pessoa.setPermissao("ROLE_ADMIN");
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0){
            pessoa.setDataCadastro(new Date());
            insertPessoa();
        }else{
            updatePessoa();
        }
    }
    
    private void insertPessoa(){
        if (comparaSenha(pessoa.getSenha(), ConverterSHA1.cipher(confereSenha))) {
            pessoaDAO().save(pessoa);
            endereco.setPessoa(pessoa);
            enderecoDAO().save(endereco);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Gravação Efetuada!!!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha não confere",null));
        }
    }
    
    
    private void updatePessoa(){
        Estado estado = new Estado();
        estado.setIdEstado(endereco.getEstado().getIdEstado());
        endereco.setEstado(estado);
        
        Cidade cidade = new Cidade();
        cidade.setIdCidade(endereco.getCidade().getIdCidade());
        endereco.setCidade(cidade);
        
        TipoEndereco tipoEndereco = new TipoEndereco();
        tipoEndereco.setIdTipoEndereco(endereco.getTipoEndereco().getIdTipoEndereco());
        endereco.setTipoEndereco(tipoEndereco);
        
        TipoLogradouro tipoLogradouro = new TipoLogradouro();
        tipoLogradouro.setIdTipoLogradouro(endereco.getTipoLogradouro().getIdTipoLogradouro());
        endereco.setTipoLogradouro(tipoLogradouro);        
        
        pessoaDAO().update(pessoa); 
        enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Atualização Efetuada!!!"));        
        
    }
    
    private boolean comparaSenha(String senha, String senhaConf){
        return senha.equals(senhaConf);
    }
            
    public void deletePessoa(){
        pessoaDAO().delete(pessoa);
        enderecoDAO().delete(endereco);
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }
    
    
    
     
    
    
}
