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
	
	private final String HTTP_URL = "http://localhost:8080/ExemploRESTv2/rest/disciplina/";
		
	@Override
	public List<Disciplina> findAll() throws IOException {
		String disciplinasJson = httpConn.getOp(HTTP_URL, "");
		String[] vetDisciplinaJson = disciplinasJson.split("List\":");
		disciplinasJson = vetDisciplinaJson[1].substring(0, vetDisciplinaJson[1].length() - 1);
		Gson gson = new Gson();
		Type disciplinasTipo = new TypeToken<ArrayList<Disciplina>>(){}.getType();
		List<Disciplina> disciplinas = gson.fromJson(disciplinasJson, disciplinasTipo);  
		return disciplinas;
	}

	@Override
	public Disciplina findOne(Disciplina disc) throws IOException {
		String disciplinaJson = httpConn.getOp(HTTP_URL, String.valueOf(disc.getCodigo()));
		String[] vetDisciplinaDTOJson = disciplinaJson.split("DTO\":");
		disciplinaJson = vetDisciplinaDTOJson[1].substring(0, vetDisciplinaDTOJson[1].length() - 1);
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
