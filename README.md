icndb-java-api
==============

## Overview

Java API client for The Internet Chuck Norris Database (http://www.icndb.com/)



## Usage

### Init

Everyting depend on ICNDBClient client object

```java
import net.joningi.icndb.ICNDBClient;

....

final ICNDBClient client = new ICNDBClient();
```

### Get single joke by ID

```java
import net.joningi.icndb.Joke;

...

Joke joke = client.getById(15);
System.out.println(joke.getId() + ": " + joke.getJoke());
```

### Get single random joke

```java
Joke randomJoke = client.getRandom();
```

### Get n random joke

```java
for (Joke j : client.getRandom(10)) {
	System.out.println(j.getId() + ": " + j.getJoke());
}
```


### Changing the name of the main character

```java
client.setFirstName("Bill");
client.setLastName("Clinton");

Joke randomJoke = client.getRandom();

client.clearName();
```

### Fetching the number of jokes

```java
System.out.println(client.getCount());
```

### Fetching the list of joke categories

```java
for (String category : client.getCategories()) {
	System.out.println(category);
}
```

### Limiting categories

```java
client.setExclude(Lists.newArrayList("explicit", "nerdy"));
Joke randomJoke = client.getRandom();
client.clearLimitAndExclude();

client.setLimitTo(Lists.newArrayList("explicit", "nerdy"));
Joke randomJoke = client.getRandom();
client.clearLimitAndExclude();
```
