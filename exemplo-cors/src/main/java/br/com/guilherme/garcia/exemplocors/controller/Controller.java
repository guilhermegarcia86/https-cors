package br.com.guilherme.garcia.exemplocors.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.garcia.exemplocors.model.Greeting;

@RestController
public class Controller {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@CrossOrigin(origins = "https://myOrigin.com")
	@GetMapping("/greeting")
	public ResponseEntity<Greeting> greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");
		return ResponseEntity.ok(new Greeting(counter.incrementAndGet(), String.format(template, name)));
	}

}
