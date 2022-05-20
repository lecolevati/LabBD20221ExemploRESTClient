package br.edu.fateczl.ExemploRestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.fateczl.ExemploRestClient.consumer.DisciplinaConsumer;
import br.edu.fateczl.ExemploRestClient.model.Disciplina;

@SpringBootTest
@AutoConfigureMockMvc
class ExemploRestClientApplicationTests {

	@Autowired
	DisciplinaConsumer dCons;
	
	@Test
	void case1() {
		Disciplina d = new Disciplina();
		d.setCodigo(2);
		d.setNome("Lab Hw");
		
		try {
			Disciplina d1 = dCons.findOne(d);
			assertEquals(d1.getNome(), "Lab Hw");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void case2() {
		try {
			List<Disciplina> disciplinas = dCons.findAll();
			assertEquals(disciplinas.size(), 5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
