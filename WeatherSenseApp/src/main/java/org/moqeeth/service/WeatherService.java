package org.moqeeth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.moqeeth.model.WeatherSenseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class WeatherService {
    @Value("${api-key}")
    private String api_key;

    @Value("${base_URL}")
    private String base_URL;

    @Value("${weather-api-uri}")
    private String weatherApi_uri_v1;

    @Value("${geo-api-uri-v1}")
    private String geoApi_uri_v1;

    @Value("${geo-api-uri-v2}")
    private String geoApi_uri_v2;

    @Value("${geo-api-uri-v3}")
    private String geoApi_uri_v3;

    public WeatherSenseResponse getAndProcessData(String city, String state, String country) {
        String url;

        if (!isNullAndEmpty(city) && !isNullAndEmpty(state) && !isNullAndEmpty(country)) {
            url = base_URL + String.format("q=%s,%s,%s&appid=%s", city, state, country, api_key);
        } else if (!isNullAndEmpty(city) && !isNullAndEmpty(country)) {
            url = base_URL + String.format("q=%s,%s&appid=%s", city, country, api_key);
        } else {
            url = base_URL + String.format("q=%s&appid=%s", city, api_key);
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), WeatherSenseResponse.class);
        } catch (IOException | InterruptedException e) {
            log.error("Failed to fetch or parse weather data", e);
            throw new RuntimeException("Failed to fetch or parse weather data", e);
        }
    }

    public boolean isNullAndEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
