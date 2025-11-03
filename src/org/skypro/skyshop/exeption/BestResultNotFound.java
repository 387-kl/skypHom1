package org.skypro.skyshop.exeption;

import java.io.IOException;

public class BestResultNotFound {
    public BestResultNotFound(String massage) {
        super("Объекты, в которых встречается \"" + massage +"\" не найдены");
    }
}
