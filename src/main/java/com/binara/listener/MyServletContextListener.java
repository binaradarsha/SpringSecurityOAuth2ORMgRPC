package com.binara.listener;

import com.binara.controller.grpc.StudentImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by binara on 7/3/17.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Starting netty server for gRPC
        try {
            server = ServerBuilder
                    .forPort(8081)
                    .addService(new StudentImpl())
                    .build();
            server.start();
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        server.shutdownNow();
        System.out.println(server.isShutdown());
    }

}
