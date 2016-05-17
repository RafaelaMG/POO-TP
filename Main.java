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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    
    
    
    public static void main(String[] args) {
        Imoobiliaria gp = new Imoobiliaria();
        menuHomepage(gp);

    }

    public static void menuHomepage(Imoobiliaria gp) {
        Imoobiliaria imo = new Imoobiliaria();
        imo = Imoobiliaria.initApp();

        Scanner scan = new Scanner(System.in);
        String saves = "";
        String acaoS = "";
        String acao = "-1";

        do {
            System.out.print('\u000C');
            System.out.println("-----------------ImOObiliaria-----------------\n");
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
        } while (acao != "0");
        try {
            gp.gravaObj("estado.tabemp");
            gp.log("log.txt", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Saida com sucesso");

    }

    public static void Login(Imoobiliaria gp) {
        Scanner scan = new Scanner(System.in);
        String cena;
        Utilizador u = new Utilizador() {};
        int acao = -1;
        String acaoS = "-1";
        String email;
        String password;
        boolean s;
        

        System.out.print('\u000C');
        System.out.println("-------------------LOGIN-------------------");
        System.out.println(" Email");
        email = scan.nextLine();
        System.out.println(" \nPassword");
        password = scan.nextLine();

        try {
            gp.iniciaSessao(email, password);
                MenuVendedor(u, gp);
           }catch (SemAutorizacaoException ex) {
            System.out.println("\n---------------------------------------------");
            System.out.println(ex.getMessage());
            System.out.println("\n 1 - Tentar Novamente       0 - Sair");
            acao = scan.nextInt();

            switch (acao) {
                case 1:
                    Login(gp);
                    break;
                default:
                    menuHomepage(gp);
                    break;
            }
        }

    }

    public static void Registar(Imoobiliaria gp) {

        
        try {
            Utilizador u= new Utilizador() {};
            Scanner scan = new Scanner(System.in);
            String ac;
            String acao;
            String acaoS = "-1";
            String email = " ";
            String password = " ";
            String nome = " ";
            String compr="Comprador";
            String vender="Vendedor";

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

            while (!(datanascimentoS.matches(DatePattern))) {
                System.out.println(" \nData de Nascimento (dd/mm/aaaa)");
                datanascimentoS = scan.nextLine();

            }

            System.out.print('\u000C');
            System.out.println("-------------------------------------------");
            System.out.printf("Email: %s; \nPassword: %s; \nNome: %s; \nMorada: %s; \nData de nascimento: %s;\n", email, password, nome, morada, datanascimentoS);
            System.out.println("-------------------------------------------");
            System.out.println(" 1 - Comprador");
            System.out.println(" 2 - Vendedor\n");
            System.out.println(" 0 - Sair");

            acao = scan.nextLine();

            switch (acao) {
                case "1":
                    Comprador c = new Comprador(new ArrayList<Imovel>(), email, password, nome, morada, datanascimentoS,compr , null){};
                    
                    try {
                        gp.registarUtilizador(c);
                    } catch (UtilizadorExistenteException ex) {
                        System.out.println(ex.getMessage());
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

                    }
                    menuHomepage(gp);

                case "2":
                    Vendedor v = new Vendedor(new HashMap<String, Imovel>(), new ArrayList<Imovel>() {}, email, password, nome, morada, datanascimentoS, null,vender ) {
                    };
                    try {
                        gp.registarUtilizador(v);
                    } catch (UtilizadorExistenteException ex) {
                        System.out.println(ex.getMessage());
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

                    }
                    menuHomepage(gp);
                    break;

                case "0":
                    menuHomepage(gp);
                    break;

            }
            gp.gravaObj("estado.temp");
            gp.log("log.txt", true);
            System.out.println("Guardado!");

        } catch (Exception ex) {
            System.out.println("Erro");
        }
    }

    public static void MenuVendedor(Utilizador u,Imoobiliaria gp) {
        try {
            Scanner scan = new Scanner(System.in);

            String acao;
                System.out.println("----------------Menu Vendedor--------------");
                System.out.println("1-Inserir imóvel");
                System.out.println("2-Consultar anúncio");
                System.out.println("3-Remover anúncio");
                System.out.println("4-Alterar anúncio");
                System.out.println("5-Estatísticas");
                System.out.println("0-Sair");
                System.out.println("-------------------------------------------");
                acao = scan.nextLine();

                switch (acao) {
                    case "1": MenuInsImovel(gp);
                        break;
                    case "2": MenuConsultasImoveis(gp, u.getEmail());
                }

            
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public static void MenuInsImovel(Imoobiliaria gp) {

        try {
            String nrua;
            String nidImovel;
            String nestado;
            String pp;
            String pm;
            int nPreçoP = 0;
            int nPreçoMin = 0;
         
            Scanner scan = new Scanner(System.in);
            String acao;
                System.out.println("-------------Inserir Imóvel--------------\n");
                System.out.println("Rua:");
                nrua=scan.nextLine();
                
                System.out.println("Atribua um ID ao imóvel:");
                nidImovel=scan.nextLine();
                
                System.out.println("Estado:");
                nestado=scan.nextLine();
                               
                System.out.println("Preço pretendido pelo proprietário:");
                pp=scan.nextLine();
                try{
                    nPreçoP=Integer.parseInt(pp);
                }catch(NumberFormatException e){
                    System.out.println("Não é um inteiro");
                }
                
                System.out.println("Preço mínimo:");
                pm=scan.nextLine();
                try{
                    nPreçoMin=Integer.parseInt(pm);
                }catch(NumberFormatException e){
                    System.out.println("Não é um inteiro");
                }
                
                
                System.out.println("------------------------------------------");
                
                System.out.println("1-Registar imóvel       2-Sair\n");
                acao=scan.nextLine();
                switch (acao) {
                    case "1": Imovel im= new Imovel(nrua, nidImovel, nestado, nPreçoP,nPreçoMin) {
                    };
                        gp.registaImovel(im);
                        System.out.println("Estas a colar e as exceções estão a fazer PUM");
                        break;
                    default: menuHomepage(gp);
                       
           }
        } catch (Exception e) {
            System.out.println("Fez PUM");
        }
    }
    
    
    
    
    public static void MenuConsultasImoveis(Imoobiliaria gp, String email){
        try{
        System.out.println("-------------Lista de Imóveis--------------\n");  
        Imovel i;
        for (int j = 0; j < gp.getImoveis().size(); j++){
            System.out.println((j+1)+"-"+gp.getImoveis2());
        }
        
        }catch(Exception e){
            System.out.println("Fez PUM!");
        }
        
    }

   
    
}
