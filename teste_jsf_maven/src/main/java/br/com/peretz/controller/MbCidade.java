package br.com.peretz.controller;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Cidade;
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
@ManagedBean(name = "mbCidade")
@SessionScoped
public class MbCidade implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }
    
    private InterfaceDAO<Cidade> cidadeDAO(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>
                           (Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }
    
    public String editCidade(){
        return "/restrict/cadastrarCidade.faces";
    }
    
    public String addCidade(){
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0){
            insertCidade();
        }else{
            updateCidade();
        }
        limpCidade();
        return null;
    }

    public String limpCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarCidade.faces";
    }
    
    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Gravação","Gravação Efetuada!!!"));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Atualização","Gravação Efetuada!!!"));
    }
    
    public void deleteCidade(){
        cidadeDAO().delete(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    
}
