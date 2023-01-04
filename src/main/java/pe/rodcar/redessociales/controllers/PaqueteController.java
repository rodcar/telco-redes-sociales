package pe.rodcar.redessociales.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.rodcar.redessociales.entities.Paquete;
import pe.rodcar.redessociales.messages.requests.PaqueteCreateRequest;
import pe.rodcar.redessociales.services.PaqueteService;

@RestController
@RequestMapping(value = "/paquetes")
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

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Validated @RequestBody PaqueteCreateRequest request) {
		try {
			Paquete paquete = Paquete.builder().nombre(request.getNombre()).descripcion(request.getDescripcion())
					.precio(request.getPrecio()).build();
			Paquete nuevoPaquete = paqueteService.save(paquete);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(nuevoPaquete.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
