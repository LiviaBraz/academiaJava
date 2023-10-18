package aula06;

import javax.swing.JOptionPane;

public class Revista implements Imprimivel {

	private String titulo;
	private String empresa;
	private int edicao;
	private boolean emprestado;
	private int nroCopias;

	public Revista(String titulo, String empresa, int edicao, int nroCopias) {

		this.titulo = titulo;
		this.empresa = empresa;
		this.edicao = edicao;
		this.emprestado = false;
		this.nroCopias = 1;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNroCopias() {
		return nroCopias;
	}

	public void setNroCopias(int nroCopias) {
		this.nroCopias = nroCopias;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public boolean reservar() {
		if (!emprestado) {
			emprestado = true;
			return true;
		} else {
			return false;
		}
	}

	public void devolver() {
		emprestado = false;
	}

	public String exibirInfo() { 

		String informacoes = ("Título: " + titulo + "\nEmpresa: " + empresa + "\nEdição: " + edicao + "\nEmprestado: "
				+ (emprestado ? "Sim" : "Não") + "\nNúmero de Cópias: " + nroCopias);
		return informacoes;

	}

	@Override
    public void imprimir() {
		
		if (isEmprestado()) {
	        JOptionPane.showMessageDialog(null, "A revista " + getTitulo() + " está emprestada e não pode ser impressa.", "Erro", JOptionPane.ERROR_MESSAGE);
	    } else {
	    	nroCopias++;
	        JOptionPane.showMessageDialog(null, "Impressão da revista " + getTitulo() + " realizada com sucesso.");
	    }
        
    }

}
