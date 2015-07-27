package br.com.peretz.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Rafael
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY; 
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static{
        try{
            System.out.println("Abrindo session factory");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder() .
                    applySettings(configuration.getProperties()).buildServiceRegistry();

            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Session Factory OK!!!");
        }catch (Exception e){
            System.out.println("Ocorreu um erro ao iniciar a Session Factory" + e.getMessage());
            throw new ExceptionInInitializerError(e);
            
        }
    }

    public static SessionFactory getSESSION_FACTORY() {
        return SESSION_FACTORY;
    }
    
}
