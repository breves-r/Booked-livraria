package edu.infnet.applivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ClienteService;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner{

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Cliente cliente = new Cliente("Maria","021999999999","maria@gmail.com","123.456.789-10");
		cliente.setUsuario(usuario);
		clienteService.incluir(cliente);
	}

}
