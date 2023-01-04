package pe.rodcar.redessociales.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.rodcar.redessociales.entities.Paquete;
import pe.rodcar.redessociales.repositories.PaqueteRepository;
import pe.rodcar.redessociales.services.PaqueteService;

@Service
public class PaqueteServiceImpl implements PaqueteService {

	@Autowired
	private PaqueteRepository paqueteRepository;
	
	@Override
	public List<Paquete> findAll() throws Exception {
		return paqueteRepository.findAll();
	}

	@Override
	public Paquete save(Paquete paquete) throws Exception {
		return paqueteRepository.save(paquete);
	}

	@Override
	public Paquete update(Paquete paquete) throws Exception {
		return paqueteRepository.save(paquete);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		paqueteRepository.deleteById(id);
	}

	@Override
	public Optional<Paquete> findById(Long id) throws Exception {
		return paqueteRepository.findById(id);
	}

}
