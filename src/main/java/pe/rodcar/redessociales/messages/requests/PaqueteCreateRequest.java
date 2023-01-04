package pe.rodcar.redessociales.messages.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaqueteCreateRequest {
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String descripcion;
	@NotNull
	@Min(0)
	private Double precio;
}
