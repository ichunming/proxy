package com.ichunming.proxy.cglib;

import com.ichunming.proxy.Article;
import com.ichunming.proxy.IArticle;

public class Test {
    public static void main(String[] args) {
          IArticle article = (IArticle) new CglibProxy().getInstance(new Article());
          article.getArticle();
     }
}
