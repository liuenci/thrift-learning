package com.liuencier.server;

import com.liuencier.service.AdditionService;
import com.liuencier.service.Hello;
import com.liuencier.service.impl.AdditionServiceImpl;
import com.liuencier.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
/**
 * @author liuenci
 */
@Slf4j
public class HelloServiceServer {

    public static void startSimpleServer(Hello.Processor<HelloServiceImpl> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9999);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startSimpleServer(new Hello.Processor<HelloServiceImpl>(new HelloServiceImpl()));
    }
}
