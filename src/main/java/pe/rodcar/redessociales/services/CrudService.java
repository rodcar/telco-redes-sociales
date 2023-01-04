package pe.rodcar.redessociales.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
	List<T> findAll() throws Exception;
	
	T save(T t) throws Exception;
	
	T update(T t) throws Exception;
	
	void deleteById(Long id) throws Exception;

	Optional<T> findById(Long id) throws Exception;
}
