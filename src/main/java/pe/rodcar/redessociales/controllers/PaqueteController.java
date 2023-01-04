package pe.rodcar.redessociales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.rodcar.redessociales.entities.Paquete;
import pe.rodcar.redessociales.services.PaqueteService;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

	@Autowired
	private PaqueteService paqueteService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paquete>> fetchAll() {
		try {
			List<Paquete> paquetes = paqueteService.findAll();
			return (paquetes.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(paquetes);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
