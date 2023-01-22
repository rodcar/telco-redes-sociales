package pe.rodcar.redessociales.messages.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaqueteCreateRequest {
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private String imagen;
	@NotNull
	@Min(0)
	private Double precio;
}
