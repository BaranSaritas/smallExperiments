package com.smallExperiments.smallExperiments;

import com.smallExperiments.smallExperiments.AsyncEventListener.CustomSpringEventPublisherAsync;
import com.smallExperiments.smallExperiments.EventListener.CustomSpringEventPublisher;
import com.smallExperiments.smallExperiments.GenericListener.GenericEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SmallExperimentsApplication implements CommandLineRunner {

	private final CustomSpringEventPublisher customSpringEventPublisher;
	private final CustomSpringEventPublisherAsync customSpringEventPublisherAsync;
	private final GenericEventPublisher genericEventPublisher;
	public static void main(String[] args) {
		SpringApplication.run(SmallExperimentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for(int i = 0; i < 10; i++) {
			customSpringEventPublisher.publishCustomEvent("Spring"+i);
		}
		System.out.println("================================");

		//ASYNC
		for(int i = 0; i < 10; i++) {
			customSpringEventPublisherAsync.publishCustomEvent("ASYNC "+i);
		}

		System.out.println("================================");

		for(int i = 0; i < 10; i++) {
			genericEventPublisher.publishEvent("My Event", true);
		}
	}
}
