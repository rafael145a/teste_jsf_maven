package br.com.peretz.support;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.TipoLogradouro;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bbTipoLogradouro")
@RequestScoped
public class BbTipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public List<TipoLogradouro> getTipoLogradouros(){
        InterfaceDAO<TipoLogradouro> tipoLogradouro = 
                new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
        return tipoLogradouro.getEntities();
    }
    
}
