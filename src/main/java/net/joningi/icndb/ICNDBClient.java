package net.joningi.icndb;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

public class ICNDBClient {
    private final APIService apiService;
    private String firstName;
    private String lastName;
    private List<String> limitTo;
    private List<String> exclude;

    public ICNDBClient() {
        this.apiService = new APIService();
    }

    public Joke getById(int id) {
        return apiService.get("jokes/" + id + buildParameters()).getJoke();
    }

    private String buildParameters() {
        QueryString queryString = new QueryString();
        if (!Strings.isNullOrEmpty(firstName)) {
            queryString.add("firstName", this.firstName);
        }
        if (!Strings.isNullOrEmpty(lastName)) {
            queryString.add("lastName", this.lastName);
        }
        if (this.limitTo != null) {
            queryString.add("limitTo", '[' + Joiner.on(',').join(this.limitTo) + ']');
        }
        if (this.exclude != null) {
            queryString.add("exclude", '[' + Joiner.on(',').join(this.exclude) + ']');
        }
        return queryString.toString();
    }

    public Joke getRandom() {
        return apiService.get("jokes/random" + buildParameters()).getJoke();
    }

    public List<Joke> getRandom(int count) {
        return apiService.getMulti("jokes/random/" + count + buildParameters()).getJokes();
    }

    public int getCount() {
        return apiService.getCount();
    }

    public List<String> getCategories() {
        return apiService.getCategories();
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void clearName() {
        this.firstName = null;
        this.lastName = null;
    }

    public void setLimitTo(List<String> list) {
        this.limitTo = list;
    }

    public void setExclude(List<String> list) {
        this.exclude = list;
    }

    public void clearLimitAndExclude() {
        this.limitTo = null;
        this.exclude = null;
    }
}
