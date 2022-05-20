package br.edu.fateczl.ExemploRestClient.model;

public class Matricula {

	private Aluno aluno;
	private Disciplina disciplina;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", disciplina=" + disciplina + "]";
	}
	
}
