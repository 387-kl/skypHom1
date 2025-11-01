package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

    public abstract class Product {

        public Product(String name) {
        }

        public abstract class product implements Searchable {

            private String name;

            public product(String name) {
                this.name = name;
            }
    }

    public String getName(String name) {
        return name;
    }
    public abstract int getPrice();

    public abstract boolean isSpecial();

    public String getSearchTerm(String name) {
        return name;
    }

    public String getContentType() {
        return "PRODUCT";
    }
}