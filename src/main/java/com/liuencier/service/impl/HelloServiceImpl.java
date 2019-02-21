package com.liuencier.service.impl;

import com.liuencier.service.Hello;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

/**
 * @author liuenci
 */
@Slf4j
public class HelloServiceImpl implements Hello.Iface{
    @Override
    public String helloString(String para) throws TException {
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return false;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("hello world");
        log.info("hello world");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}
