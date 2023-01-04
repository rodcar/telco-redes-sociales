package pe.rodcar.redessociales.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.rodcar.redessociales.entities.Paquete;
import pe.rodcar.redessociales.messages.requests.PaqueteCreateRequest;
import pe.rodcar.redessociales.messages.requests.PaqueteUpdateRequest;
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

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Paquete>> fetchById(@PathVariable("id") Long id) {
		try {
			Optional<Paquete> paquete = paqueteService.findById(id);
			return (paquete.isPresent()) ? ResponseEntity.ok(paquete) : ResponseEntity.notFound().build();
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

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paquete> update(@PathVariable("id") Long id,
			@Validated @RequestBody PaqueteUpdateRequest request) {
		try {
			Paquete paquete = Paquete.builder().id(id).nombre(request.getNombre()).descripcion(request.getDescripcion())
					.precio(request.getPrecio()).build();
			Paquete paqueteActualizado = paqueteService.update(paquete);
			return ResponseEntity.ok(paqueteActualizado);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		try {
			if (paqueteService.existsById(id)) {
				paqueteService.deleteById(id);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
