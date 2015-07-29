package br.com.peretz.support;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.Sexo;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bbSexo")
@RequestScoped
public class BbSexo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos(){
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO<Sexo>(Sexo.class, FacesContextUtil.getRequestSession());
        return sexoDAO.getEntities();
    }
    
}
