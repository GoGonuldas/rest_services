package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "GET REQUEST") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/greeting")
	public Greeting creategreeting(@RequestParam(value = "name", defaultValue = "POST REQUEST") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PutMapping("/greeting")
	public Greeting updategreeting(@RequestParam(value = "name", defaultValue = "PUT REQUEST") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@DeleteMapping("/greeting")
	public Greeting deletegreeting(@RequestParam(value = "name", defaultValue = "DELETE REQUEST") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(method = RequestMethod.GET)
	public Greeting test(@RequestParam(value = "name", defaultValue = "DELETE REQUEST") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
