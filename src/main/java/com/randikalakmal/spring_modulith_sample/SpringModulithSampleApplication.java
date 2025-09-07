package com.randikalakmal.spring_modulith_sample;

import com.randikalakmal.spring_modulith_sample.allocation.Slot;
import com.randikalakmal.spring_modulith_sample.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringModulithSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringModulithSampleApplication.class, args);
	}


	// populate some data to DB when the application is started

	@Bean
	CommandLineRunner init(SlotRepository slotRepository) {
		return args -> {
			if (slotRepository.findAll().isEmpty()) {
				slotRepository.save(new Slot(null, "A1", true, null));
				slotRepository.save(new Slot(null, "A2", true, null));
				slotRepository.save(new Slot(null, "B1", true, null));
				slotRepository.save(new Slot(null, "B2", true, null));
				slotRepository.save(new Slot(null, "C1", true, null));
				slotRepository.save(new Slot(null, "C2", true, null));
			}
		};
	}

}
