/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import p1.poo.fatecpg.noturno.Disciplinas;

/**
 * Web application lifecycle listener.
 *
 * @author trize
 */
public class DbListener implements ServletContextListener {
public static final String CLASS_NAME = "org.sqlite.JDBC";
public static final String DB_URL = "jdbc:sqlite:C:\\Users\\trize\\Documents\\POO.ADS.NOTURNO\\tasks-noturno.db";
public static String exceptionMessage = null;
public static Connection getConnection()throws Exception{
    return DriverManager.getConnection(DB_URL);
}

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    Connection con = null; Statement stmt = null;
        try {
            Class.forName(CLASS_NAME);
            con = DriverManager.getConnection(DB_URL);
            stmt = con.createStatement();
            stmt.execute(Disciplinas.getCreateStatment());
            if(Disciplinas.getList().isEmpty()){
            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Banco de Dados' ,"
                                    +"'Conceitos Banco de Dados',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Engenharia de Software III' ,"
                                    +"'Conceitos, evolução e importância de arquitetura de software',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Programacao Orientada a Objetos' ,"
                                    +"'Conceitos e evolução da tecnologia de orientação a objetos.',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Linguagem de Programacao IV - INTERNET' ,"
                                    +"'Comandos de linguagens usadas na construcao e estruturacao de sites para a Web',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Seguranca da Informacao' ,"
                                    +"'Requisitos de seguranca de aplicacoes, de base de dados e de comunicacoes.',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Sistemas Operacionais II' ,"
                                    +"'Apresentacao de um sistema operacional especifico utilizado em ambiente corporativo.',"
                                    +"4,"
                                    +"10);");

            stmt.execute("INSERT INTO disciplinas VALUES("
                                    +"'Metodologia da Pesquisa Cientifico-Tecnologica' ,"
                                    +"'O Papel da ciência e da tecnologia. Tipos de conhecimento. Metodo e tecnica.',"
                                    +"4,"
                                    +"10);");
            }
        } catch (Exception ex) {
        } finally{
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
