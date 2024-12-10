package org.bou;

import java.util.*;

public class XspeedltAlgorithm implements IXspeedltAlgorithm {
    private static final int CARTON_CAPACITY = 10;

    @Override
    public String optimizePackingOfArticles(String articles) {
        // List pour stocker la capacité de chaque carton utilisé
        List<Integer> cartonCapacities = new ArrayList<>();
        // List qui contient les articles packagé
        List<String> articlesByCarton = new ArrayList<>();
        boolean packed = false;
        int newArticle;
        // On parcours la liste des articles
        for (int i = 0; i < articles.length(); i++) {
            newArticle = Character.getNumericValue(articles.charAt(i));
            // On parcours les cartons utilisé pour trouver où placer nouveau carton
            for (int j = 0; j < cartonCapacities.size(); j++) {
                if (cartonCapacities.get(j) + newArticle <= CARTON_CAPACITY) {
                    cartonCapacities.set(j, cartonCapacities.get(j) + newArticle);
                    articlesByCarton.set(j, articlesByCarton.get(j) + articles.charAt(i));
                    packed = true;
                    break;
                }
            }

            if (!packed) {
                cartonCapacities.add(newArticle);
                articlesByCarton.add(String.valueOf(articles.charAt(i)));
            }
            packed = false;
        }

        return String.join("/", articlesByCarton);
    }
}
