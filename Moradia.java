/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.ArrayList;
import java.util.List;


public class Moradia extends Imovel implements Habitavel
{
   
   private double areaImpl; //área de implantação 
   private double areaCoberta; //área total coberta 
   private double areaTerreno; //área do terreno à volta
   private int quartos;
   private int wc;
   private int porta; //número da porta

    public Moradia( double areaImpl, double areaCoberta, double areaTerreno, int quartos, int wc, int porta, List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(cons ,rua, idImovel, estado, tipo, idP, precoP, precoM);
        
        this.areaImpl = areaImpl;
        this.areaCoberta = areaCoberta;
        this.areaTerreno = areaTerreno;
        this.quartos = quartos;
        this.wc = wc;
        this.porta = porta;
      
    }

    public Moradia(Moradia i) {
        super(i);
       
        this.areaImpl = i.getAreaImpl();
        this.areaCoberta = i.getAreaCoberta();
        this.areaTerreno = i.getAreaTerreno();
        this.quartos = i.getQuartos();
        this.wc = i.getWc();
        this.porta = i.getPorta();
    }

    public Moradia() {
        super();
        
        this.areaImpl = 0.0;
        this.areaCoberta = 0.0;
        this.areaTerreno = 0.0;
        this.quartos = 0;
        this.wc = 0;
        this.porta = 0;
    }
  
    
    
    public int getQuartos() {
        return quartos;
    }

    public int getWc() {
        return wc;
    }
    
    public double getAreaT(){
    double areaT = (areaImpl + areaCoberta + areaTerreno);
    
    return areaT;  
    }

   

    public double getAreaImpl() {
        return areaImpl;
    }

    public double getAreaCoberta() {
        return areaCoberta;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    public int getPorta() {
        return porta;
    }

   

    public void setAreaImpl(double areaImpl) {
        this.areaImpl = areaImpl;
    }

    public void setAreaCoberta(double areaCoberta) {
        this.areaCoberta = areaCoberta;
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

   public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Area de Implantação " + this.getAreaImpl() + "\n");
        s.append("Area coberta " + this.getAreaCoberta() + "\n");
        s.append("Area de terreno: " + this.getAreaTerreno()+ "\n");
        s.append("Porta: " + this.getPorta()+ "\n");
        s.append("Quartos: " + this.getQuartos()+ "\n");
       
       
        return s.toString();
    }
   
   public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Moradia u=(Moradia) o;
        return (this.areaImpl==u.getAreaImpl() && this.areaCoberta==u.getAreaCoberta()&& this.areaTerreno==u.getAreaTerreno() && this.porta==u.getPorta() && this.quartos==u.getQuartos());
    }
    
}
 
    
  public Moradia clone(){
        return new Moradia(this);
    } 
    
 
}

