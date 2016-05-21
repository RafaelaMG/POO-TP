/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.List;




public class Apartamento extends Imovel implements Habitavel

{
    
    private String tipoA; // atribuitmos inteiros ao tipo (Simples, Duplex, Triplex);
    private double areaT; // area total do apartamento;
    private int quartosA; 
    private int wcA;
    private int porta;
    private int andar;
    private String garagem; //atribuir 0 ou 1 para caso tenha ou não garagem

    public Apartamento(double areaT, int quartosA, int wcA, int porta, int andar, String garagem,List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int precoP, int precoM) {
        super(cons, rua, idImovel, estado, tipo, wcA, precoP, precoM);
        this.tipoA = tipoA;
        this.areaT = areaT;
        this.quartosA = quartosA;
        this.wcA = wcA;
        this.porta = porta;
        this.andar = andar;
        this.garagem = garagem;
    }

    public Apartamento(Apartamento i) {
        super(i);
        this.tipoA = i.getTipoA();
        this.areaT = i.getAreaT();
        this.quartosA = i.getQuartos();
        this.wcA = i.getWc();
        this.porta = i.getPorta();
        this.andar = i.getAndar();
        this.garagem = i.getGaragem();
    }

    public Apartamento() {
        super();
        this.tipoA = new String();
        this.areaT = 0.0;
        this.quartosA = 0;
        this.wcA = 0;
        this.porta = 0;
        this.andar = 0;
        this.garagem = new String();
    }

    public String getTipoA() {
        return tipoA;
    }

    public int getPorta() {
        return porta;
    }

    public int getAndar() {
        return andar;
    }

    public String getGaragem() {
        return garagem;
    }
    
    public int getQuartos() {
        return quartosA;
    }

    public int getWc() {
        return wcA;
    }

    public double getAreaT() {
        return areaT;
    }

    public void setTipoA(String tipoA) {
        this.tipoA = tipoA;
    }

    public void setAreaT(double areaT) {
        this.areaT = areaT;
    }

    public void setQuartos(int quartosA) {
        this.quartosA = quartosA;
    }

    public void setWc(int wcA) {
        this.wcA = wcA;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setGaragem(String garagem) {
        this.garagem = garagem;
    }

   public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Tipo de Apartamento " + this.getTipoA() + "\n");
        s.append("Número de quartos " + this.getQuartos() + "\n");
        s.append("Número de casas de banho: " + this.getWc() + "\n");
        s.append("Porta: " + this.getPorta()+ "\n");
        s.append("Andar: " + this.getAndar()+ "\n");
        s.append("Garagem: " + this.getGaragem() + "\n");
       
        return s.toString();
    }

   public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Apartamento u=(Apartamento) o;
        return (this.tipoA.equals(u.getTipoA()) && this.quartosA==u.getQuartos() && this.wcA== u.getWc() && this.porta==u.getPorta() && this.andar==u.getAndar() && this.garagem.equals(u.getGaragem()));
    }
    
}

        public Apartamento clone(){
        return new Apartamento(this);
    }
    
    
    
    
   
 
}



