package dev.luanfernandes.gestao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import static java.net.InetAddress.getLocalHost;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class UserAdminApplication implements CommandLineRunner {

    private final Environment env;

    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String host = getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");

        String urlBase = String.format("http://%s:%s", host, port);
        if (contextPath != null && !contextPath.isEmpty() && !contextPath.equals("/")) {
            urlBase += contextPath;
        }
        log.info("Application started at {}", urlBase);
        log.info("OpenAPI documentation available at {}/swagger-ui.html", urlBase);
    }
}
