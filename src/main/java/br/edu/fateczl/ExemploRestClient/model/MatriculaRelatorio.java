package br.edu.fateczl.ExemploRestClient.model;

public class MatriculaRelatorio {
	
	private String raAluno;
	private String nomeAluno;
	private String emailAluno;
	private int codigoDisicplina;
	private String nomeDisciplina;
	
	public String getRaAluno() {
		return raAluno;
	}
	public void setRaAluno(String raAluno) {
		this.raAluno = raAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public int getCodigoDisicplina() {
		return codigoDisicplina;
	}
	public void setCodigoDisicplina(int codigoDisicplina) {
		this.codigoDisicplina = codigoDisicplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public String toString() {
		return "MatriculaRelatorio [raAluno=" + raAluno + ", nomeAluno=" + nomeAluno + ", emailAluno=" + emailAluno
				+ ", codigoDisicplina=" + codigoDisicplina + ", nomeDisciplina=" + nomeDisciplina + "]";
	}
}
