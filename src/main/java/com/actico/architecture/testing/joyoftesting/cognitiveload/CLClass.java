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

public class CLClass {


    public String getCoffee() throws URISyntaxException, IOException, InterruptedException {

        record Coffee(String description, String image, List<String> ingredients, String title, int id) {
        }
        var hotCoffeeRequest = HttpRequest.newBuilder().uri(new URI("https://api.sampleapis.com/coffee/hot")).GET().build();


        var icedCoffeeRequest = HttpRequest.newBuilder().uri(new URI("https://api.sampleapis.com/coffee/hot")).GET().build();


        List<Coffee> coffeeList;
        try (var client = HttpClient.newHttpClient()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            var response = client.send(hotCoffeeRequest, HttpResponse.BodyHandlers.ofString());
            coffeeList = objectMapper.readValue(response.body(), new TypeReference<>() {
            });
        }

        try (var client = HttpClient.newHttpClient()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            var response = client.send(icedCoffeeRequest, HttpResponse.BodyHandlers.ofString());
            coffeeList.addAll(objectMapper.readValue(response.body(), new TypeReference<List<Coffee>>() {
            }));
        }

        return coffeeList.stream()
                .filter(coffee -> coffee.ingredients() != null)
                .filter(coffee -> coffee.ingredients().contains("Coffee"))
                .distinct()
                .map(Coffee::title).reduce((a, b) -> a + ", " + b)
                .orElse("No coffee found");
    }


}
