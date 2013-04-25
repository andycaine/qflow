package qflow;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

public class Application {

    private final int port;

    private Server server;

    public Application(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        server = new Server(port);

        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setContextConfigLocation("classpath:spring.xml");

        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");
        handler.addServlet(new ServletHolder(servlet), "/*");
        server.setHandler(handler);

        server.start();
    }

    public void stop() throws Exception {
        server.stop();
        server.join();
    }
}
