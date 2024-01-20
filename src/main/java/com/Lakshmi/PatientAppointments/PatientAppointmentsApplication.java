package com.Lakshmi.PatientAppointments;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "patient Appointment Application Documentation",
				description = "patient Appointment Application Documentation",
				version = "v1.0",
				contact = @Contact(
						name="Gunalan"
				)
		)
)
public class PatientAppointmentsApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PatientAppointmentsApplication.class, args);
	}

}
