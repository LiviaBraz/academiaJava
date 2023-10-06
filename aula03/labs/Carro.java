package aula03;

import java.util.Scanner;

public class Carro {	
    
    private String marca;
    private String modelo;
    private int ano;
    private double precoDiaria;
    private boolean disponivel;

    public Carro(String marca, String modelo, int ano, double precoDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precoDiaria = precoDiaria;
        this.disponivel = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void alugarCarro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Carro alugado com sucesso!");
        } else {
            System.out.println("Desculpe, o carro já está alugado.");
        }
    }

    public void devolverCarro() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Carro devolvido com sucesso!");
        } else {
            System.out.println("O carro está disponível.");
        }
    }

    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
        
    	Carro carro1 = new Carro("Chevrolet", "Omega", 1998, 150.0);

        System.out.println("Marca: " + carro1.getMarca());
        System.out.println("Modelo: " + carro1.getModelo());
        System.out.println("Ano: " + carro1.getAno());
        System.out.println("Preço da Diária: R$" + carro1.getPrecoDiaria());

        carro1.alugarCarro();
        
        System.out.println("\nVocê quer devolver o carro? Digite 'S' para Sim e 'N' para Não");
        String devolver = scan.next(); 
        
        if (devolver.equalsIgnoreCase("s")) {
        	carro1.devolverCarro();
        } 
    }
}