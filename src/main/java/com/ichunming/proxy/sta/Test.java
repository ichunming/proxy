package com.ichunming.proxy.sta;

import com.ichunming.proxy.Article;
import com.ichunming.proxy.IArticle;

public class Test {
    public static void main(String[] args) {
          // 目标对象
          IArticle target = new Article();
          // 代理对象
          IArticle articleProxy = (IArticle)new ArticleProxy(target);
          // 通过代理对象调用目标对象的方法
          articleProxy.getArticle();
     }
}
