package com.spring.bakery;

import com.spring.bakery.modelo.EstadoPedido;
import com.spring.bakery.modeloDTO.EstadoUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BakeryApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
