package org.bou;

public class Main {
    public static void main(String[] args) {

        String articles = "163841689525773";

        IXspeedltAlgorithm xspeedltAlgorithm = new XspeedltAlgorithm();
        System.out.println(xspeedltAlgorithm.optimizePackingOfArticles(articles));
    }
}