package net.joningi.icndb;

import java.util.List;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.GsonBuilder;

public class APIService {

    public static final String BASE_URL = "http://api.icndb.com/";

    protected final Client client;

    public APIService() {
        this.client = javax.ws.rs.client.ClientBuilder.newClient();
    }

    private String request(String url) {
        try {
            final WebTarget myResource = client.target(url);
            return myResource.request(MediaType.TEXT_PLAIN).get(String.class);
        } catch (NotFoundException e) {
            return null;
        }
    }

    public Container get(final String value) {
        return new GsonBuilder().create().fromJson(request(BASE_URL + value), Container.class);
    }

    public MultiContainer getMulti(final String value) {
        return new GsonBuilder().create().fromJson(request(BASE_URL + value), MultiContainer.class);
    }

    public int getCount() {
        return new GsonBuilder().create().fromJson(request(BASE_URL + "jokes/count"),
                CountContainer.class).getCount();
    }

    public List<String> getCategories() {
        return new GsonBuilder().create().fromJson(request(BASE_URL + "/categories"),
                CategoriesContainer.class).getCategories();
    }
}
