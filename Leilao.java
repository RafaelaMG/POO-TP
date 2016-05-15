/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;


public interface Leilao
{
   /*private float valor; valor de inicio do leilao
   private float valorProposto; valor proposto pelo comprador
   private String nomeComprador; nome do comprador com a proposta mais alta;
   private int estado; //estado do leilao
   private Imovel imovelL; //imovel e leilão*/
   
   public void iniciaLeilao (Imovel im , int horas);
   public void adicionaComprador (String idComprador ,double limite ,double incrementos ,double minutos);
   public Comprador encerraLeilao ();

}

