package com.smallExperiments.smallExperiments;

import com.smallExperiments.smallExperiments.EventListenerExample.AsyncEventListener.CustomSpringEventPublisherAsync;
import com.smallExperiments.smallExperiments.EventListenerExample.EventListener.CustomSpringEventPublisher;
import com.smallExperiments.smallExperiments.EventListenerExample.GenericListener.GenericEventPublisher;
import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.StudentService;
import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.config.IntegrationConfig;
import com.smallExperiments.smallExperiments.SpringBasicMessageIntegration.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@RequiredArgsConstructor
@Import(IntegrationConfig.class)

public class SmallExperimentsApplication implements CommandLineRunner {

	private final CustomSpringEventPublisher customSpringEventPublisher;
	private final CustomSpringEventPublisherAsync customSpringEventPublisherAsync;
	private final GenericEventPublisher genericEventPublisher;
	private final StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(SmallExperimentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 10; i++) {
			studentService.addStudent(new Student((long) i, "Student", i));
		}





		/*  Event Listeners Test

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

		*/

	}
}
