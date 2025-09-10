package com.sparta.library.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2TcpServerConfig {

    // Expose the in-memory H2 database over TCP so external tools (IntelliJ) can connect.
    // Connect using: jdbc:h2:tcp://localhost:9092/mem:library
    @Bean(destroyMethod = "stop")
    public Server h2TcpServer() throws SQLException {
        Server server = Server.createTcpServer(
                "-tcp",
                "-tcpPort", "9092",
                "-tcpAllowOthers",
                "-ifNotExists"
        );
        server.start();
        System.out.println("H2 TCP server started: " + server.getURL());
        return server;
    }
}

