package com.ichunming.proxy.sta;

import com.ichunming.proxy.IArticle;

public class ArticleProxy implements IArticle {
    // 目标对象
    private IArticle article;

    public ArticleProxy(IArticle article) {
          this.article = article;
     }

    public void getArticle() {
          // 前置消息
          doBefore();
          // 调用具体方法
          article.getArticle();
          // 后置消息
          doAfter();
     }

    public void doBefore() {
          System.out.println("do before target's method");
     }
    public void doAfter() {
          System.out.println("do after target's method");
     }
}
