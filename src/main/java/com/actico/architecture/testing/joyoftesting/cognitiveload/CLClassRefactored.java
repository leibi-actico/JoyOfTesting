package com.actico.architecture.testing.joyoftesting.cognitiveload;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class CLClassRefactored {

    public static final String COFFEE_BASEURL = "https://api.sampleapis.com/coffee/";

    record Coffee(String description, String image, List<String> ingredients, String title, int id) {
    }

    HttpRequest hotCoffeeRequest = getCoffeeRequest("hot").orElseThrow();
    HttpRequest icedCoffeeRequest = getCoffeeRequest("iced").orElseThrow();

    private static Optional<HttpRequest> getCoffeeRequest(String type) {
        try {
            var uri = new URI(COFFEE_BASEURL + type);
            return Optional.of(HttpRequest.newBuilder().uri(uri).GET().build());
        } catch (URISyntaxException e) {
            return Optional.empty();
        }
    }


    public String getCoffee() throws IOException, InterruptedException {


        List<Coffee> coffeeList = getCoffees(hotCoffeeRequest);

        try (var client = HttpClient.newHttpClient()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            var response = client.send(icedCoffeeRequest, HttpResponse.BodyHandlers.ofString());
            List<Coffee> tmp = (objectMapper.readValue(response.body(), new TypeReference<List<Coffee>>() {
            }));
            coffeeList.addAll(tmp.stream().filter(coffee -> coffee.ingredients() != null)
                    .filter(coffee -> !coffee.ingredients().contains("sugar"))
                    .distinct()
                    .toList());
        }

        return coffeeList.stream()
                .filter(coffee -> coffee.ingredients() != null)
                .filter(coffee -> coffee.ingredients().contains("Coffee"))
                .distinct()
                .map(Coffee::title).reduce((a, b) -> a + ", " + b)
                .orElse("No coffee found");
    }

    private List<Coffee> getCoffees(HttpRequest request) throws IOException, InterruptedException {
        List<Coffee> coffeeList;
        try (var client = HttpClient.newHttpClient()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            coffeeList = objectMapper.readValue(response.body(), new TypeReference<>() {
            });
        }
        return coffeeList;
    }


}
