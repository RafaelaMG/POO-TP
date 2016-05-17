/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.Serializable;


public abstract class Imovel implements Serializable
{
    private String rua;
    private String idImovel;
    private String estado;
    private int preçoP; //preço pedido pelo proprietário 
    private int preçoM; // preço mínimo que não deve ser visível ao utilizador.

    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public String getEstado(){
        return estado;
    }
    
    public void setEstadoI(String Estado){
        this.estado=estado;
    }
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getPreçoP() {
        return preçoP;
    }

    public void setPreçoP(int preçoP) {
        this.preçoP = preçoP;
    }

    public int getPreçoM() {
        return preçoM;
    }

    public void setPreçoM(int preçoM) {
        this.preçoM = preçoM;
    }

   
    
    public Imovel(String rua, String idImovel, String estado, int preçoP, int preçoM) {
        this.rua = rua;
        this.estado=estado;
        this.preçoP = preçoP;
        this.preçoM = preçoM;
        this.idImovel=idImovel;
    }


    public Imovel(Imovel i){
        this.rua=i.getRua();
        this.estado=i.getEstado();
        this.preçoP=i.getPreçoP();
        this.preçoM=i.getPreçoM();
        this.idImovel=i.getIdImovel();
    }


    public Imovel(){
        this.rua=new String();
        this.preçoP=0;
        this.preçoM=0;
        this.idImovel=new String();
        this.estado=new String();
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Rua: " + this.getRua() + "\n");
        s.append("Id do imóvel: " + this.getIdImovel() + "\n");
        s.append("Estado do imóvel " + this.getEstado() + "\n");
        s.append("Valor pretendido: " + this.preçoP + "\n");
        s.append("Valor mínimo " + this.preçoM + "\n");
        return s.toString();
    }

    public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Imovel i=(Imovel) o;
        return (this.rua.equals(i.getRua()) && this.idImovel.equals(i.getIdImovel()) && this.estado.equals(i.getEstado()) && this.preçoM == i.getPreçoM() && this.preçoP == i.getPreçoP());
    }
    }
    
    public Imovel Clone(){
        return new Imovel(this) {};
    }

}

