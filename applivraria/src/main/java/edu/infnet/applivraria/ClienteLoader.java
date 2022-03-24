package edu.infnet.applivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.service.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner{

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente cliente = new Cliente("Maria","021999999999","maria@gmail.com","123.456.789-10");
		clienteService.incluir(cliente);
	}

}
