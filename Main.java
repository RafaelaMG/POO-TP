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
        Imoobiliaria gp= new Imoobiliaria();
        Imoobiliaria.initApp();
        menuHomepage(gp);
        
        

    }

    public static void menuHomepage(Imoobiliaria gp) {
        
        try {
            gp = Imoobiliaria.leObj("estado.tabemp");
        } catch (IOException e) {
            gp = new Imoobiliaria();
            System.out.println("Não existem dados gravados|\nErro de leitura.");
        } catch (ClassNotFoundException e) {
            gp = new Imoobiliaria();
            System.out.println("Não é possível ler os dados!\nFicheiro com formato desconhecido.");
        } catch (ClassCastException e) {
            gp = new Imoobiliaria();
            System.out.println("Não é possível ler os dados!\nErro de formato.");
        }

        Scanner scan = new Scanner(System.in);
        String saves = "";
        String acaoS = "";
        String acao = "-1";

       // do {
            System.out.print('\u000C');
            System.out.println("-----------------ImOObiliaria-----------------\n");
            System.out.println(" 1 - Fazer Login\n");
            System.out.println(" 2 - Registar\n");
            System.out.println(" 9 - Gravar\n\n");
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
                case "9": try {
                    gp.gravaObj("estado.tabemp");
                    System.out.println("Guardado");
                    menuHomepage(gp);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                default:
                    System.exit(0);
                    break;
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
 private int m;
    public void setIde(int novo){
        this.m=novo;
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
                    Utilizador c=new Utilizador(email, nome, password, morada, datanascimentoS,0, new ArrayList()) {
                    };
                    
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
                    Utilizador v = new Utilizador(email, nome, password, morada, datanascimentoS, 1, new ArrayList<Imovel>()){
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
            try{
            gp.gravaObj("basedados.obj");
            System.out.println("Guardado");}
            catch(IOException e){
                System.out.println(e.getMessage());
            }
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
                System.out.println("3-Estatísticas");
                System.out.println("0-Sair");
                System.out.println("-------------------------------------------");
                acao = scan.nextLine();

                switch (acao) {
                    case "1": 
                        MenuInsImovel(gp, u);
                
                        break;
                    case "2": MenuConsultasImoveis(gp, u);
                }

            
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    

    public static void MenuInsImovel(Imoobiliaria gp, Utilizador u) {

        try {
            String nrua;
            String nidImovel;
            String nestado;
            String pp;
            String pm;
            int nPreçoP = 0;
            int nPreçoMin = 0;
            String tipo;
         
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
                
                System.out.println("Tipo de imóvel (Moradia|Apartamento|Terreno)");
                tipo=scan.nextLine();
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
                    case "1": Imovel im= new Imovel(nrua, nidImovel, nestado, tipo, nPreçoP, nPreçoP, nPreçoP){
                    };
                        try {
                            gp.registaImovel(im);
                            System.out.println("És uma colada mas quando paras de colar...");
                        } catch (ImovelExisteException imo) {
                            System.err.println(imo.getMessage());
                        } catch (SemAutorizacaoException se) {
                            System.err.println(se.getMessage());
                        }
                        
                        break;
                    default: menuHomepage(gp);
                       
           }
        } catch (Exception e) {
            System.out.println("Fez PUM");
        }
    }
    
   
    
    
    public static void MenuConsultasImoveis(Imoobiliaria gp, Utilizador u){
        String ac;
         String acaoS = "";
        String saves = "";
        String acao = "-1";
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------Lista de Imóveis--------------\n");  
        int i=1;
        for (Imovel s : gp.getImoveis()) {
            System.out.println(i + "-" + s.getRua());
            i++;
        } System.out.println("\n--------------------------------------------------------------");
        System.out.println("\n(Selecione o número do Imóvel que pretende consultar)\n");


        System.out.println(" \n0 - Voltar atrás\n");

        acao = scan.nextLine();
        Imovel escolha;
        List<Imovel> listImovel = gp.getImoveis();
        
          switch (acao) {
            case "0":
                menuHomepage(gp);
                break;
            default:
                int acao2int = Integer.parseInt(acao) - 1;

                if (acao2int >= 0 && acao2int < listImovel.size()) {
                    escolha = listImovel.get(acao2int);
                    System.out.println("\n--------------------------------------------------------------");
                 
                    
                        System.out.println("\nRua: " + escolha.getRua());
                        System.out.println("\nId do Imóvel: " + escolha.getIdImovel());
                        System.out.println("\nEstado: " + escolha.getEstado());
                        System.out.println("\nPreço pretendido pelo proprietário: " + escolha.getPrecoP());
                        System.out.println("\nTipo de Imóvel: " + escolha.getTipo());
                        System.out.println("\nPreço Mínimo: " + escolha.getPrecoM());
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.println("\n0 - Voltar atrás");
                        System.out.println("\n1 - Editar Estado do Imóvel");
                        System.out.println("\n2 - Remover Imóvel");
                  
                        System.out.println("\n--------------------------------------------------------------");
                        ac = scan.nextLine();
                            switch (ac) {
                            case "0":
                                MenuConsultasImoveis(gp, u);
                            case "1":
                                MenuEditarEstado(gp, escolha, u);

                            case "2":
                                gp.elmImovel(escolha);
                                MenuConsultasImoveis(gp, u);

                        }
                               
                    }
                break;
                    }
                }
                
    public static void MenuEditarEstado(Imoobiliaria gp, Imovel i, Utilizador u){
          try {
            Scanner scan = new Scanner(System.in);
            String acao;
            String acaoS = "-1";
            String nEstado;
            
            System.out.println("-----------------Editar Estado-----------------\n");
            System.out.println("Vendido | Em venda | Reservado\n");
            System.out.println("Novo estado: ");
            nEstado=scan.nextLine();
            
            System.out.println("\n1-Alterar Estado    2-Sair");
            acao=scan.nextLine();
            
            switch(acao){
                case "1": gp.setEstado(i.getIdImovel(), nEstado);
                          MenuConsultasImoveis(gp, u);
                
                default: menuHomepage(gp);
                break;
            }
            
            
          }catch(Exception e){
              System.out.println("Erro");
          }
    
}
        }

    

