package com.app.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

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
        context.addFilterDef(createFilterDef("filter",TomcatFilter.class.getName()));
        context.addFilterMap(createFilterMap("filter", "/*"));
        tomcat.addServlet(context, TomcatServlet.class.getSimpleName(), new TomcatServlet());
        context.addServletMappingDecoded("/talk", TomcatServlet.class.getSimpleName());


        tomcat.start();
        tomcat.getServer().await();
    }

    private static FilterDef createFilterDef(String filterName, String filterClass) {
        FilterDef filterDef = new FilterDef();
        filterDef.setFilterName(filterName);
        filterDef.setFilterClass(filterClass);
        return filterDef;
    }

    private static FilterMap createFilterMap(String filterName, String urlPattern) {
        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName(filterName);
        filterMap.addURLPattern(urlPattern);
        return filterMap;
    }
}
