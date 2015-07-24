package br.com.peretz.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Rafael
 */
public class PhaseListenerTeste implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            System.out.println("After: " + getPhaseId().getName());
            Session session = HibernateUtil.getSESSION_FACTORY().openSession();
            try{
                
                session.getTransaction().commit();
                
            }catch (Exception e){
                if(session.getTransaction().isActive()){
                    
                    session.getTransaction().rollback();
                }
            } finally{
            
            session.close();
            
        }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Before: " + getPhaseId().getName());
            Session session = HibernateUtil.getSESSION_FACTORY().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    
    
}
