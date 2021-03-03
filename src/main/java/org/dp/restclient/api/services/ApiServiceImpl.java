package org.dp.restclient.api.services;

import java.util.List;

import org.dp.restclient.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public final String API_URL;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.API_URL = api_url;
	}

	@Override
	public List<User> getUsers(Integer limit) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(API_URL).queryParam("_limit", limit);
		List<User> users = restTemplate.getForObject(uriBuilder.toUriString(), List.class);
		return users;
	}

	@Override
	public Flux<User> getUsers(Mono<Integer> limit) {
		// TODO Auto-generated method stub
		return WebClient.create(API_URL).get().uri(uriBuilder -> uriBuilder.queryParam("limit", limit).build())
				.accept(MediaType.APPLICATION_JSON)
				.exchangeToFlux(response -> {
			         //if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToFlux(User.class);
//			         }else if (response.statusCode().is4xxClientError()) {
//			             return response.bodyToMono(ErrorContainer.class).flux();
//			         }
//			         else {
//			             return Flux.error(response.createException());
//			         }
			     });
	}


}
