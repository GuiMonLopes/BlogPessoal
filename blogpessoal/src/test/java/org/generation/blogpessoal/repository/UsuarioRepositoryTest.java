package org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeAll
	void start() {
		Usuario usuario = new Usuario("RafaelLopes", "RafaelLopes", "134652");
		if (repository.findByUsuario(usuario.getUsuario()) != null) {
			repository.save(usuario);
		}
			

		usuario = new Usuario("DanieliLopes", "DanieliLopes", "134652");
		if (repository.findByUsuario(usuario.getUsuario()) != null){
			repository.save(usuario);
		}

		usuario = new Usuario("AsdolfoLopes", "AsdolfoLopes", "134652");
		if (repository.findByUsuario(usuario.getUsuario()) != null){
			repository.save(usuario);
		}
	}

	@Test
	public void findByUsuarioRetornaUsuario() throws Exception {

		Usuario usuario = repository.findByUsuario("RafaelLopes").get();
		assertTrue(usuario.getUsuario().equals("RafaelLopes"));
	}

	@Test
	public void findAllByUsuarioContainingIgnoreCaseRetornaTresContato() {

		List<Usuario> listaDeUsuarios = repository.findAllByUsuarioContainingIgnoreCase("Lopes");
		assertEquals(3, listaDeUsuarios.size());
	}

	@AfterAll
	public void end() {
		repository.deleteAll();
	}

}
