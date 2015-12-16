package com.ichunming.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    
    // 生成代理对象
    public Object bind(Object target) {
          this.target = target;
          return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
     }

    // 动态调用目标对象方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        // 切面之前执行
        System.out.println("do before target's method");
        // 执行业务
        result = method.invoke(target, args);
        // 切面之后执行
        System.out.println("do after target's method");
        return result;
    }
}
