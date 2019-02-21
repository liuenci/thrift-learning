package com.liuencier.server;

import com.liuencier.service.AdditionService;
import com.liuencier.service.impl.AdditionServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class MyServer {

    public static void startSimpleServer(AdditionService.Processor<AdditionServiceImpl> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startSimpleServer(new AdditionService.Processor<AdditionServiceImpl>(new AdditionServiceImpl()));
    }
}
