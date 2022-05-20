package br.edu.fateczl.ExemploRestClient.consumer;

import java.io.IOException;
import java.util.List;

public interface IOperacoesConsumer<T> {

	public List<T> findAll() throws IOException;
	public T findOne(T t) throws IOException;
	public String save(T t) throws IOException;
	public String modify(T t) throws IOException;
	public String delete(T t) throws IOException;
	
}
