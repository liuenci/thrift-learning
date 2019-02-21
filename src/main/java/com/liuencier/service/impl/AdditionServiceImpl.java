package com.liuencier.service.impl;

import com.liuencier.service.AdditionService;
import org.apache.thrift.TException;

public class AdditionServiceImpl implements AdditionService.Iface{
    @Override
    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }
}
