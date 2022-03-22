package edu.infnet.applivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Endereco;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.UsuarioService;



@Component
public class UsuarioLoader implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Bairro do Admin");
		endereco.setCep("99.999-99");
		endereco.setComplemento("Complemento do Admin");
		endereco.setLocalidade("Localidade do Admin");
		endereco.setLogradouro("Logradouro do Admin");
		endereco.setUf("UF");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Rafaela Curty");
		usuario.setEmail("rafaela.curty@infnet.com");
		usuario.setSenha("123");
		usuario.setAdmin(true) ;
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
	}

}
