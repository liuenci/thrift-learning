package com.liuencier.client;

import com.liuencier.service.AdditionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class AdditionClient {

    public static void main(String[] args) {
        try {
            TTransport tTransport;
            tTransport = new TSocket("localhost",9090);
            tTransport.open();
            TProtocol protocol = new TBinaryProtocol(tTransport);
            AdditionService.Client client = new AdditionService.Client(protocol);
            System.out.println(client.add(100,200));
            tTransport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
