package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

    DBConnectionManager dbConnectionManager = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            System.out.println("init DBConnection");
            dbConnectionManager = new DBConnectionManager();
            dbConnectionManager.init();
            DatabaseUserRepository.userRepository = new DatabaseUserRepository(dbConnectionManager);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dbConnectionManager.releaseConnection();
    }
}
