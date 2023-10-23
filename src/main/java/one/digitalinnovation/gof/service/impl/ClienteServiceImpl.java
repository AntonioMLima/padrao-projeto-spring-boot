package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.service.ConsultarRegiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ConsultarUF;


@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UnidadeFederativaRepository unidadeFederativaRepository;
	@Autowired
	private ConsultarUF cosultarPorUf;
	@Autowired
	private ConsultarRegiao consultarRegiao;
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComUnidadeFederativa(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComUnidadeFederativa(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComUnidadeFederativa(Cliente cliente) {
		Integer id = cliente.getUnidadeFerativativa().getId();
		Regiao regiaoFed = consultarRegiao.consultarRegiao(cliente.getUnidadeFerativativa().getId());
		regiaoRepository.save(regiaoFed);
		UnidadeFerativativa unidadeFed = unidadeFederativaRepository.findById(id).orElseGet(() -> {
			UnidadeFerativativa novaUnidade = cosultarPorUf.consultarUF(id);
			unidadeFederativaRepository.save(novaUnidade);
			return novaUnidade;
		});
		cliente.setUnidadeFerativativa(unidadeFed);;
		clienteRepository.save(cliente);
	}

}
