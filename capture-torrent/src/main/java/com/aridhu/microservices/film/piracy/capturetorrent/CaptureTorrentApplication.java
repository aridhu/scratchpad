package com.aridhu.microservices.film.piracy.capturetorrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CaptureTorrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptureTorrentApplication.class, args);
	}
}
