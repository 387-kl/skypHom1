package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        //Демонстрация классов
        //Добавление продукта в корзину.
        basket.addToBasket(new SimpleProduct("egg", 100));
        //Заполнение корзины
        basket.addToBasket(new SimpleProduct("milk", 80));
        basket.addToBasket(new DiscountedProduct("cookie", 150, 10));
        basket.addToBasket(new FixPriceProduct("vegetable cutter"));
        basket.addToBasket(new SimpleProduct("sugar", 60));

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addToBasket(new SimpleProduct("sugar", 60));

        //Печать содержимого корзины с несколькими товарами.
        basket.printProductsOfBasket();
        SearchEngine searchEngine = new SearchEngine(10);

        //Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.getSumOfProducts());
        searchEngine.add( new SimpleProduct("milk", 80));
        searchEngine.add( new DiscountedProduct("cookie", 150, 10));
        searchEngine.add( new FixPriceProduct("vegetable cutter"));
        searchEngine.add( new SimpleProduct("sugar", 60));
        searchEngine.add( new SimpleProduct("egg", 100));

        //Поиск товара, который есть в корзине.
        System.out.println(basket.checkProductInBasket("salt"));

        //Поиск товара, которого нет в корзине.
        System.out.println(basket.checkProductInBasket("carrot"));
        searchEngine.add(new Article("Ночник",
                "Ночник для новорожденных с генератором белого шума"));
        searchEngine.add(new Article("Видеоняня",
                "Видеоняня с монитором, беспроводная 1280 * 720 HD"));

        //Очистка корзины.
        basket.cleanBasket();
        Searchable[] result = searchEngine.search("g");

        //Печать содержимого пустой корзины.
        basket.printProductsOfBasket();
        System.out.println(Arrays.toString(result));

        //Получение стоимости пустой корзины.
        System.out.println(basket.getSumOfProducts());

        //Поиск товара по имени в пустой корзине.
        System.out.println(basket.checkProductInBasket("carrot"));

    }
}
