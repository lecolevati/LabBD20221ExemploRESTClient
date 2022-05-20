package br.edu.fateczl.ExemploRestClient.consumer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.fateczl.ExemploRestClient.model.Disciplina;
import br.edu.fateczl.ExemploRestClient.util.HTTPConn;

@Component
public class DisciplinaConsumer implements IOperacoesConsumer<Disciplina> {

	@Autowired
	HTTPConn httpConn;
	
	private final String HTTP_URL = "http://localhost:8080/ExemploREST/rest/disciplina/";
		
	@Override
	public List<Disciplina> findAll() throws IOException {
		String disciplinasListJson = httpConn.getOp(HTTP_URL, "");
		String[] vetDisciplinaDTOJson = disciplinasListJson.split("List\":");
		String disciplinasJson = vetDisciplinaDTOJson[1].replaceAll("\\{\"disciplina\":","");
		disciplinasJson = disciplinasJson.replaceAll("\\}\\}","\\}");
		disciplinasJson = disciplinasJson.substring(0, disciplinasJson.length() - 1);
		Gson gson = new Gson();
		Type disciplinasTipo = new TypeToken<ArrayList<Disciplina>>(){}.getType();
		List<Disciplina> disciplinas = gson.fromJson(disciplinasJson, disciplinasTipo);  
		return disciplinas;
	}

	@Override
	public Disciplina findOne(Disciplina disc) throws IOException {
		String disciplinaDTOJson = httpConn.getOp(HTTP_URL, String.valueOf(disc.getCodigo()));
//		{"DisciplinaDTO":{"disciplina":{"codigo":5,"nome":"Lab BD"}}}
		String[] vetDisciplinaDTOJson = disciplinaDTOJson.split("disciplina\":");
		String disciplinaJson = vetDisciplinaDTOJson[1].substring(0, vetDisciplinaDTOJson[1].length() - 2);
		Gson gson = new Gson();
		Disciplina disciplina = gson.fromJson(disciplinaJson, Disciplina.class);  
		return disciplina;
	}

	@Override
	public String save(Disciplina disc) throws IOException {
		String saida = httpConn.sendOp(HTTP_URL, RequestMethod.POST, disc);
		return saida;
	}

	@Override
	public String modify(Disciplina disc) throws IOException {
		String saida = httpConn.sendOp(HTTP_URL, RequestMethod.PUT, disc);
		return saida;		
	}

	@Override
	public String delete(Disciplina disc) throws IOException {
		String saida = httpConn.sendOp(HTTP_URL, RequestMethod.DELETE, disc);
		return saida;		
	}

}
