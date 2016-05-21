/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


public class Loja extends Apartamento
{
   private double areaL; //area total
   private int wc; //atribuir 0 ou 1 caso tenha wc ou não
   private String negocio; //comentário sobre negócios viáveis
   private int portaL; 
   

    public Loja(double areaL, int wc, String negocio, int portaL,String tipoA, double areaT, int quartosA, int wcA, int porta, int andar, String garagem,List<Consulta> cons, String rua, String idImovel, String estado, String tipo,int precoP, int precoM) {
        super(areaT, quartosA, wcA, porta, andar, garagem, cons, rua, idImovel, estado, tipo, precoP, precoM);
        this.areaL = areaL;
        this.wc = wc;
        this.negocio = negocio;
        this.portaL = portaL;
      
    }

    public Loja(Loja i) {
        super(i);
        this.areaL = i.getAreaL();
        this.wc = i.getWc();
        this.negocio = i.getNegocio();
        this.portaL = i.getPortaL();
        
    }

    public Loja() {
        super();
        this.areaL = 0.0;
        this.wc = 0;
        this.negocio = "";
        this.portaL = 0;
      
        
    }

   
   
   
    public double getAreaL() {
        return areaL;
    }

    public int getWc() {
        return wc;
    }

    public String getNegocio() {
        return negocio;
    }

    public int getPortaL() {
        return portaL;
    }

   

    public void setAreaL(double areaL) {
        this.areaL = areaL;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public void setPortaL(int portaL) {
        this.portaL = portaL;
    }

    

  public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Loja u=(Loja) o;
        return (this.areaL==u.getAreaL() && this.wc==u.getWc() && this.negocio.equals(u.getNegocio()) && this.portaL==u.getPortaL());
    }
    
}
  
  public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Area total " + this.getAreaT() + "\n");
        s.append("Número de casas de banho: " + this.getWc() + "\n");
        s.append("Negocio: " + this.getNegocio()+ "\n");
        s.append("Porta: " + this.getPortaL()+ "\n");
      
       
        return s.toString();
    }
  
  
  
   
    public Loja clone(){
        return new Loja(this);
    }
   
  
}

