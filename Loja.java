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
   private int habit; // se é habitável ou não

    public Loja(double areaL, int wc, String negocio, int portaL, int habit, int tipoA, double areaT, int quartosA, int wcA, int porta, int andar, String garagem,List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(tipoA, areaT, quartosA, wcA, porta, andar, garagem,cons, rua, idImovel, estado, tipo, idP, precoP, precoM);
        this.areaL = areaL;
        this.wc = wc;
        this.negocio = negocio;
        this.portaL = portaL;
        this.habit = habit;
    }

    public Loja(Loja i) {
        super(i);
        this.areaL = i.getAreaL();
        this.wc = i.getWc();
        this.negocio = i.getNegocio();
        this.portaL = i.getPortaL();
        this.habit = i.getHabit();
    }

    public Loja() {
        super();
        this.areaL = 0.0;
        this.wc = 0;
        this.negocio = "";
        this.portaL = 0;
        this.habit =0;
        
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

    public int getHabit() {
        return habit;
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

    public void setHabit(int habit) {
        this.habit = habit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loja other = (Loja) obj;
        if (Double.doubleToLongBits(this.areaL) != Double.doubleToLongBits(other.areaL)) {
            return false;
        }
        if (this.wc != other.wc) {
            return false;
        }
        if (this.portaL != other.portaL) {
            return false;
        }
        if (this.habit != other.habit) {
            return false;
        }
        if (!Objects.equals(this.negocio, other.negocio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Loja{" + "areaL=" + areaL + ", wc=" + wc + ", negocio=" + negocio + ", portaL=" + portaL + ", habit=" + habit + '}';
    }
  
   
    public Loja clone(){
        return new Loja(this);
    }
   
  
}

