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
  
    private double diametro; // canalização (milimetros)
    private double potencia; // kWh máximo da rede elétrica.
    private String acesso; // existe ou não acessso a esgotos;

    public Terreno(double areaT, double diametro, double potencia, String acesso,List<Consulta> cons, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(cons, rua, idImovel, estado, tipo, idP, precoP, precoM);
        this.areaT = areaT;
       
        this.diametro = diametro;
        this.potencia = potencia;
        this.acesso = acesso;
    }

    public Terreno(Terreno i) {
        super(i);
        this.areaT = i.getArea();
       
        this.diametro = i.getDiametro();
        this.potencia = i.getPotencia();
        this.acesso = i.getAcesso();
    }

    public Terreno() {
        super();
        this.areaT = 0.0;
        
        this.diametro = 0.0;
        this.potencia = 0.0;
        this.acesso = new String();
    }
    
    
    public double getArea() {
        return areaT;
    }

    public void setAreaT(double areaT) {
        this.areaT = areaT;
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

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    
   public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Area total:  " + this.getArea() + "\n");
        s.append("Diametro " + this.getDiametro() + "\n");
        s.append("Potencia: " + this.getPotencia()+ "\n");
        s.append("Acesso: " + this.getAcesso()+ "\n");
       return s.toString();
    }

   
   public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Terreno u=(Terreno) o;
        return (this.areaT==u.getArea() && this.diametro==u.getDiametro() && this.potencia==u.getPotencia() && this.acesso.equals(u.getAcesso()));
    }
   }
   
    
 public Terreno clone(){
        return new Terreno(this);
    }   
    
    
}

