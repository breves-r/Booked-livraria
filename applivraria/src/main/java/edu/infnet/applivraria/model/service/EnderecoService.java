package edu.infnet.applivraria.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.clients.IEnderecoClient;
import edu.infnet.applivraria.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscarCep(String cep) {

		return enderecoClient.buscarCep(cep);
	}

}
