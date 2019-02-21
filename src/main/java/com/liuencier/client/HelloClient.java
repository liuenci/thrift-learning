package com.liuencier.client;

import com.liuencier.service.Hello;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
@Slf4j
public class HelloClient {

    private static final String HELLO = "HELLO";
    private static final Boolean FALSE = false;

    public static void main(String[] args) {
        try {
            TTransport tTransport;
            tTransport = new TSocket("localhost",9999);
            tTransport.open();
            TProtocol protocol = new TBinaryProtocol(tTransport);
            Hello.Client client = new Hello.Client(protocol);

            log.info("helloString:{}",client.helloString(HELLO));
            log.info("helloBoolean:{}",client.helloBoolean(FALSE));
            log.info("helloInt:{}",client.helloInt(2));
            client.helloVoid();
//            log.info("helloNull:{}",client.helloNull());
            tTransport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
