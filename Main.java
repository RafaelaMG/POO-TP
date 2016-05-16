/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Imoobiliaria imo = new Imoobiliaria();
        Utilizador r = new Utilizador("a60991@alunos.uminho.pt", "Rafaela", "lei","Braga","09/11/1992") {};
        try {
            imo.registarUtilizador(r);
        } catch (UtilizadorExistenteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            File f = new File("basedados.obj");
            if (f.exists()) {

                ObjectInputStream ooin
                        = new ObjectInputStream(new FileInputStream("basedados.obj"));
                imo = (Imoobiliaria) ooin.readObject();
                ooin.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ec) {
        };
        menuHomepage(imo);

    }

    public static void menuHomepage(Imoobiliaria gp) {
        Scanner scan = new Scanner(System.in);
        String saves = "";
        String acaoS = "";
        String acao = "-1";

        while (acao != "0") {
            System.out.print('\u000C');
            System.out.println("-----------------FitnessUM-----------------\n");
            System.out.println(" 1 - Fazer Login\n");
            System.out.println(" 2 - Registar\n\n");
            System.out.println(" 0 - Sair                                ");
            System.out.println("-------------------------------------------");
            acao = scan.nextLine();

            switch (acao) {
                case "1":
                    Login(gp);
                    break;
                case "2":
                    Registar(gp);
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
            acao = "0";

        }

    }

    public static void Login(Imoobiliaria gp) {
        Scanner scan = new Scanner(System.in);
        int acao = -1;
        String acaoS = "-1";
        String email;
        String password;

        System.out.print('\u000C');
        System.out.println("-------------------LOGIN-------------------");
        System.out.println(" Email");
        email = scan.nextLine();
        System.out.println(" \nPassword");
        password = scan.nextLine();

        

        try {
            gp.iniciaSessao(email, password);
        } catch (SemAutorizacaoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\n########## Erro de autenticação! ##########");
            System.out.println("\n 1 - Tentar Novamente       0 - Sair");
            System.out.println(" ");
            acao = scan.nextInt();
        }
            //menuPrincipal(gp, email);
           
            acao = scan.nextInt();
            switch (acao) {
                case 1:
                    Login(gp);
                    break;
                case 0:
                    menuHomepage(gp);
                    break;
                default:
                    menuHomepage(gp);
                    break;
            }
        }

    

    public static void Registar(Imoobiliaria gp) {

        try {
            Scanner scan = new Scanner(System.in);
            String ac;
            String acao;
            String acaoS = "-1";
            String email = " ";
            String password = " ";
            String nome = " ";
            
            String morada = " ";
            String datanascimentoS = "";
            
            
            String DatePattern = "^(?:(31)(\\D)(0?[13578]|1[02])\\2|(29|30)(\\D)(0?[13-9]|1[0-2])\\5|(0?[1-9]|1\\d|2[0-8])(\\D)(0?[1-9]|1[0-2])\\8)((?:1[6-9]|[2-9]\\d)?\\d{2})$|^(29)(\\D)(0?2)\\12((?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$";

            System.out.print('\u000C');
            System.out.println("-----------------REGISTAR-----------------\n");
            System.out.println(" \nEmail");
            email = scan.nextLine();
            System.out.println(" \nPassword");
            password = scan.nextLine();
            System.out.println(" \nNome");
            nome = scan.nextLine();
            
            System.out.println(" \nMorada");
            morada = scan.nextLine();

           System.out.println("Data de nascimento");
           datanascimentoS=scan.nextLine();
           
            System.out.print('\u000C');
            System.out.println("-------------------------------------------");
            System.out.printf("Email: %s; \nPassword: %s; \nNome: %s; \nMorada: %s; \nData de nascimento: %s;", email, password, nome, morada, datanascimentoS);
            System.out.println("-------------------------------------------");
            System.out.println(" 1 - Confirmar Registo");
            System.out.println(" 2 - Cancelar Registo\n");
            System.out.println(" 0 - Sair");

            acao = scan.nextLine();

            switch (acao) {
                case "1":
                    Utilizador u = new Utilizador(email, password, nome, morada, datanascimentoS) {};
                    gp.registarUtilizador(u);

                    
                        System.out.println("\n Este nome Email já existe!");
                        System.out.println("\n 2 - Tentar Novamente       0 - Sair");
                        ac = scan.nextLine();

                        switch (ac) {
                            case "2":
                                Registar(gp);
                                break;
                            case "0":
                                menuHomepage(gp);
                                break;
                            default:
                                menuHomepage(gp);
                                break;
                        }
                    

                    gp.registarUtilizador(u);
                    try {
                        gp.gravaObj("basedados.obj");
                        System.out.println("GUARDADO!");

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    menuHomepage(gp);

                case "2":
                    Registar(gp);
                    break;

                case "0":
                    menuHomepage(gp);
                    break;

            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

