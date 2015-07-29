package br.com.peretz.support;

import br.com.peretz.model.dao.HibernateDAO;
import br.com.peretz.model.dao.InterfaceDAO;
import br.com.peretz.model.entities.TipoEndereco;
import br.com.peretz.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.web.context.request.RequestScope;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<TipoEndereco> getTiposEnderecos(){
        InterfaceDAO<TipoEndereco> tipoEndereco = new HibernateDAO<TipoEndereco>(
                                    TipoEndereco.class, FacesContextUtil.getRequestSession());
        return tipoEndereco.getEntities();
    }
}
