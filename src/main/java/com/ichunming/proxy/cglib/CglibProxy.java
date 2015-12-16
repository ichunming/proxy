package com.ichunming.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor  {
    // 目标对象
    private Object target;

   // 生成代理对象
   public Object getInstance(Object target) {
       this.target = target; 
       Enhancer enhancer = new Enhancer();
        // 设定父类，代理类是目标类的子类
       enhancer.setSuperclass(this.target.getClass()); 
       // 回调方法，真正调用intercept方法 
       enhancer.setCallback(this); 
       // 创建代理对象 
       return enhancer.create(); 
   }

   // 动态调用目标对象方法
   @Override
   public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
       Object result = null;
       // 前置消息
       System.out.println("do before target's method");
       // 调用具体方法
       result = proxy.invokeSuper(obj, args);
       // 后置消息
       System.out.println("do after target's method");
       return result;
   }
}