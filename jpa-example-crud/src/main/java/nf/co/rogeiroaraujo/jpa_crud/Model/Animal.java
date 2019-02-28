package nf.co.rogeiroaraujo.jpa_crud.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// a entidade (classe) que será mapeada
public class Animal implements Serializable{
    @Id // define a chave primaria
    @GeneratedValue // define a forma que o valor para o id será gerada
    private int id; // prmary key
    private String specie;
    private String nome;

    public Animal() {
    }

    public Animal(int id, String raca, String nome) {
        this.id = id;
        this.specie = raca;
        this.nome = nome;
    }

    public Animal(String raca, String nome) {
        this();
        this.specie = raca;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return specie;
    }

    public void setRaca(String raca) {
        this.specie = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", raca='" + specie + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
