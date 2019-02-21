package com.liuencier;

import org.apache.thrift.TException;

public class AdditionServiceImpl implements AdditionService.Iface{
    @Override
    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }
}
