package p1.poo.fatecpg.noturno;
import java.sql.*;
import java.util.ArrayList;
import model.DbListener;

public class Disciplinas {
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;        

    public ArrayList<Disciplinas> getList() throws Exception {
        ArrayList<Disciplinas> lst = new ArrayList<>();
        Connection con = null;Statement stmt = null;ResultSet rs = null;
        Exception methodException = null;
        try {
            con = DbListener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM disciplinas;");
            while(rs.next()){
                lst.add(new Disciplinas(
                rs.getString("nome"),
                rs.getString("ementa"),
                rs.getInt("ciclo"),
                rs.getDouble("nota")
                ));
            }
        } catch (Exception ex) {
            methodException = ex;
        } finally{
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
            try{rs.close();}catch(Exception ex2){}
        }
        if(methodException!=null) throw methodException;
        return lst;
    }
    
    public Disciplinas(String nome, String ementa, int ciclo, double nota) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
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

    public double getNota() {
        return nota;
    }

    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplinas("
                + "nome VARCHAR(200) PRIMARY KEY,"
                + "ementa VARCHAR(780) NOT NULL,"
                + "ciclo NUMBER(2) NOT NULL,"
                + "nota NUMBER(2, 2) NOT NULL"
                + ");";
    }
    
}