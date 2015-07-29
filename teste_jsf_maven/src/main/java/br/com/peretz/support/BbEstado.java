package br.com.peretz.support;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Estado;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estado = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estado.getEntities();
    }
    
    
}
