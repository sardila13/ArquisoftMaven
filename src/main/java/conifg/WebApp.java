package conifg;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class WebApp extends ResourceConfig {
	public WebApp(){
        packages("rest");
    }
}