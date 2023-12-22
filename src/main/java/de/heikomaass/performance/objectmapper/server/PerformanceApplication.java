package de.heikomaass.performance.objectmapper.server;

import de.heikomaass.performance.objectmapper.controller.ControllerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;


@SpringBootConfiguration
@EnableAutoConfiguration
@Import(ControllerConfiguration.class)
public class PerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceApplication.class, args);
	}

}
