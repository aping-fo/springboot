package com.app.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * Created by lucky on 2017/12/20.
 */
public class TomcatServer {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(System.getProperty("user.dir")+"/tomcat");
        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        Context context = tomcat.addContext("/game", tmpDir.getAbsolutePath());
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.addServlet(context, TomcatServlet.class.getSimpleName(), new TomcatServlet());
        context.addServletMappingDecoded("/talk", TomcatServlet.class.getSimpleName());
        tomcat.start();
        tomcat.getServer().await();
    }
}
