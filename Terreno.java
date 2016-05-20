/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.List;


public class Terreno extends Imovel
{
    private double areaT; // area total de construção
    private int tipoTerreno; // atribuir inteiros para o caso de ser apropriado para habitação ou armazéns.
    private double diametro; // canalização (milimetros)
    private double potencia; // kWh máximo da rede elétrica.
    private int acesso; // existe ou não acessso a esgotos;

    public Terreno(double areaT, int tipoTerreno, double diametro, double potencia, int acesso,List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(cons, rua, idImovel, estado, tipo, idP, precoP, precoM);
        this.areaT = areaT;
        this.tipoTerreno = tipoTerreno;
        this.diametro = diametro;
        this.potencia = potencia;
        this.acesso = acesso;
    }

    public Terreno(Terreno i) {
        super(i);
        this.areaT = i.getArea();
        this.tipoTerreno = i.getTipoTerreno();
        this.diametro = i.getDiametro();
        this.potencia = i.getPotencia();
        this.acesso = i.getAcesso();
    }

    public Terreno() {
        super();
        this.areaT = 0.0;
        this.tipoTerreno = 0;
        this.diametro = 0.0;
        this.potencia = 0.0;
        this.acesso = 0;
    }
    
    
    public double getArea() {
        return areaT;
    }

    public void setAreaT(double areaT) {
        this.areaT = areaT;
    }

    public int getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(int tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
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
        final Terreno other = (Terreno) obj;
        if (Double.doubleToLongBits(this.areaT) != Double.doubleToLongBits(other.areaT)) {
            return false;
        }
        if (this.tipoTerreno != other.tipoTerreno) {
            return false;
        }
        if (Double.doubleToLongBits(this.diametro) != Double.doubleToLongBits(other.diametro)) {
            return false;
        }
        if (Double.doubleToLongBits(this.potencia) != Double.doubleToLongBits(other.potencia)) {
            return false;
        }
        if (this.acesso != other.acesso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Terreno{" + "areaT=" + areaT + ", tipoTerreno=" + tipoTerreno + ", diametro=" + diametro + ", potencia=" + potencia + ", acesso=" + acesso + '}';
    }
    
 public Terreno clone(){
        return new Terreno(this);
    }   
    
    
}

