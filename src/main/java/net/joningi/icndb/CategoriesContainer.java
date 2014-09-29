package net.joningi.icndb;

import java.util.List;

public class CategoriesContainer extends AbstractContainer<List<String>> {
    public List<String> getCategories() {
        return this.value;
    }
}
