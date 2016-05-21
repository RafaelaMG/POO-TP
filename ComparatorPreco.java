/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Comparator;

/**
 *
 * @author Demo
 */
public class ComparatorPreco implements Comparator<Imovel> {
    public int compare(Imovel i1, Imovel i2){
        int n1=i1.getPrecoM();
        int n2=i2.getPrecoM();
        
        if(n1>n2) return 1;
        return -1;
    }
    
    
}
