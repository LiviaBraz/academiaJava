package aula07;

import java.time.LocalDate;

public class Cachorro extends Animal {

    public Cachorro(String nome, String raca, LocalDate dataNascimento, String proprietario) {
        super(nome, "Cachorro", raca, dataNascimento, proprietario);
    }

}
