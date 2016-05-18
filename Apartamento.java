/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;




public class Apartamento extends Imovel implements Habitavel

{
    
    private int tipoA; // atribuitmos inteiros ao tipo (Simples, Duplex, Triplex);
    private double areaT; // area total do apartamento;
    private int quartosA; 
    private int wcA;
    private int porta;
    private int andar;
    private int garagem; //atribuir 0 ou 1 para caso tenha ou não garagem
    private int hab = 1;
    
    
    public int getHabitavel(){
        return hab;
    
    }
   
 
}



