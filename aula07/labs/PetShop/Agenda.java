package aula07;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private String animal;
	private String servico;
	private String data;
	private String horario;
	
	static List<Agenda> listaAgenda = new ArrayList<Agenda>();

	public Agenda() {
		super();
	}

	public Agenda(String animal, String servico, String data, String horario) {
		super();
		this.animal = animal;
		this.servico = servico;
		this.data = data;
		this.horario = horario;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public static List<Agenda> listandoAgenda() {
		return listaAgenda;
	}

}