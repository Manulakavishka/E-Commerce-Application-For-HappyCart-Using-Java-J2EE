package com.happycart.web.application.listener;

import com.happycart.web.application.provider.MailServiceProvider;
import com.happycart.web.application.util.Env;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("BASE_URL", context.getContextPath()+"/");
        Env.getProperties().put("app_url","http://localhost:8080"+context.getContextPath());
        System.out.println("ContectInitialized");
        MailServiceProvider.getInstance().start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MailServiceProvider.getInstance().shutdown();
    }
}
