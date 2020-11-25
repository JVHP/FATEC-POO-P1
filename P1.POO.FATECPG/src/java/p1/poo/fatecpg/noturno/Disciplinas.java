package p1.poo.fatecpg.noturno;
import java.util.ArrayList;

public class Disciplinas {
    ArrayList<Disciplinas> disciplinas = new ArrayList<>();
    String nome;
    String ementa;
    int ciclo;
    float nota;        

    public Disciplinas(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public float getNota() {
        return nota;
    }

    public void setList(ArrayList<Disciplinas> list) {
        disciplinas = list;
    }
    
    public void setterList(Disciplinas disc) {
        disciplinas.add(disc);
    }
    
    public ArrayList<Disciplinas> getList() {
        return disciplinas;
    }

}