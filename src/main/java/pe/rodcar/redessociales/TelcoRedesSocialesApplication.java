package pe.rodcar.redessociales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TelcoRedesSocialesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelcoRedesSocialesApplication.class, args);
	}

}
