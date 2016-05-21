/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.List;




public class Apartamento extends Imovel implements Habitavel

{
    
    private int tipoA; // atribuitmos inteiros ao tipo (Simples, Duplex, Triplex);
    private double areaT; // area total do apartamento;
    private int quartosA; 
    private int wcA;
    private int porta;
    private int andar;
    private String garagem; //atribuir 0 ou 1 para caso tenha ou não garagem

    public Apartamento(int tipoA, double areaT, int quartosA, int wcA, int porta, int andar, String garagem,List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int precoP, int precoM) {
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
        this.tipoA = 0;
        this.areaT = 0.0;
        this.quartosA = 0;
        this.wcA = 0;
        this.porta = 0;
        this.andar = 0;
        this.garagem = new String();
    }

    public int getTipoA() {
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

    public void setTipoA(int tipoA) {
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
        final Apartamento other = (Apartamento) obj;
        if (this.tipoA != other.tipoA) {
            return false;
        }
        if (Double.doubleToLongBits(this.areaT) != Double.doubleToLongBits(other.areaT)) {
            return false;
        }
        if (this.quartosA != other.quartosA) {
            return false;
        }
        if (this.wcA != other.wcA) {
            return false;
        }
        if (this.porta != other.porta) {
            return false;
        }
        if (this.andar != other.andar) {
            return false;
        }
        if (this.garagem.equals(garagem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apartamento{" + "tipoA=" + tipoA + ", areaT=" + areaT + ", quartosA=" + quartosA + ", wcA=" + wcA + ", porta=" + porta + ", andar=" + andar + ", garagem=" + garagem + '}';
    }
    

        public Apartamento clone(){
        return new Apartamento(this);
    }
    
    
    
    
   
 
}



