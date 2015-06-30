/*
 * Copyright 2014 Azazo
 *
 */
package net.joningi;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;

public class TestClient {
    public static void main(String[] args) {
        ICNDBClient client = new ICNDBClient();

        Joke joke = client.getById(15);
        System.out.println(joke.getId() + ": " + joke.getJoke());

        client.setFirstName("Bill");
        client.setLastName("Clinton");
        Joke randomJoke = client.getRandom();
        System.out.println(randomJoke.getId() + ": " + randomJoke.getJoke());

        client.clearName();

        System.out.println("Random n: 4");
        for (Joke j : client.getRandom(4)) {
            System.out.println(j.getId() + ": " + j.getJoke());
        }


        System.out.println("Getting total count of jokes");
        System.out.println(client.getCount());

        System.out.println("Categories");
        for (String category : client.getCategories()) {
            System.out.println(category);
        }

        client.setLimitTo(Lists.newArrayList("explicit", "nerdy"));
        randomJoke = client.getRandom();
        System.out.println(randomJoke.getId() + ": " + randomJoke.getJoke());
        client.clearLimitAndExclude();
    }
}