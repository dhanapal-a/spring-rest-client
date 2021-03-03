package org.dp.restclient.api.services;

import java.util.List;

import org.dp.restclient.api.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {

	List<User> getUsers(Integer limit);
	Flux<User> getUsers(Mono<Integer> limit);
}
