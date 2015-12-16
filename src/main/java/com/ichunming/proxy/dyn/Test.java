package com.ichunming.proxy.dyn;

import com.ichunming.proxy.Article;
import com.ichunming.proxy.IArticle;

public class Test {
    public static void main(String[] args) {
          IArticle article = (IArticle) new DynamicProxy().bind(new Article());
          article.getArticle();
     }
}
