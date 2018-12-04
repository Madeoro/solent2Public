package gropuPackage.web.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApp extends ResourceConfig {

    public RestApp() {
        packages("gropuPackage.web.rest");
    }
}
