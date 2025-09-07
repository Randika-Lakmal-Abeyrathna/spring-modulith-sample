package com.randikalakmal.spring_modulith_sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SpringModulithSampleApplicationTests {

	@Test
	void contextLoads() {

		ApplicationModules module = ApplicationModules.of(SpringModulithSampleApplication.class)
				.verify();
		new Documenter(module).writeDocumentation();

	}

}
