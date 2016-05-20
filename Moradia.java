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
   private int tipo; //vamos atribuir inteiros aos tipos (isolada, geminada, banda, gaveto)
   private double areaImpl; //área de implantação 
   private double areaCoberta; //área total coberta 
   private double areaTerreno; //área do terreno à volta
   private int quartos;
   private int wc;
   private int porta; //número da porta

    public Moradia(int tipom, double areaImpl, double areaCoberta, double areaTerreno, int quartos, int wc, int porta, List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(cons ,rua, idImovel, estado, tipo, idP, precoP, precoM);
        this.tipo = tipom;
        this.areaImpl = areaImpl;
        this.areaCoberta = areaCoberta;
        this.areaTerreno = areaTerreno;
        this.quartos = quartos;
        this.wc = wc;
        this.porta = porta;
      
    }

    public Moradia(Moradia i) {
        super(i);
        this.tipo = i.getTipom();
        this.areaImpl = i.getAreaImpl();
        this.areaCoberta = i.getAreaCoberta();
        this.areaTerreno = i.getAreaTerreno();
        this.quartos = i.getQuartos();
        this.wc = i.getWc();
        this.porta = i.getPorta();
    }

    public Moradia() {
        super();
        this.tipo = 0;
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

    public int getTipom() {
        return tipo;
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

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Moradia other = (Moradia) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (Double.doubleToLongBits(this.areaImpl) != Double.doubleToLongBits(other.areaImpl)) {
            return false;
        }
        if (Double.doubleToLongBits(this.areaCoberta) != Double.doubleToLongBits(other.areaCoberta)) {
            return false;
        }
        if (Double.doubleToLongBits(this.areaTerreno) != Double.doubleToLongBits(other.areaTerreno)) {
            return false;
        }
        if (this.quartos != other.quartos) {
            return false;
        }
        if (this.wc != other.wc) {
            return false;
        }
        if (this.porta != other.porta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Moradia{" + "tipo=" + tipo + ", areaImpl=" + areaImpl + ", areaCoberta=" + areaCoberta + ", areaTerreno=" + areaTerreno + ", quartos=" + quartos + ", wc=" + wc + ", porta=" + porta + '}';
    }
 
    
  public Moradia clone(){
        return new Moradia(this);
    } 
    
 
}

