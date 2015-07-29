package br.com.peretz.support;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Cidade;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades(){
        InterfaceDAO<Cidade> cidade = new HibernateDAO<Cidade>(Cidade.class,FacesContextUtil.getRequestSession());
        return cidade.getEntities();
    }
    
    
}
