package net.joningi.icndb;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MultiContainer extends AbstractContainer<List<Joke>> {
    public List<Joke> getJokes() {
        return this.value;
    }
}
