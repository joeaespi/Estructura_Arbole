/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.SortedListSet;

/**
 *
 * @author EVOTEC
 */
public class Main {
    public static void main(String[] args){
        SLSet<Integer> sls = new SLSet<>(Integer::compareTo);
        sls.add(5);
        sls.add(20);
        sls.add(15);
        sls.add(10);
        System.out.println("Conjunto A");
        System.out.println(sls.toString());
        System.out.println(sls.remove(10));
        System.out.println(sls.toString() + "este es el conjunto despues de eliminar un elemento");
        
        System.out.println("Conjunto B");
        SLSet<Integer> sls2 = new SLSet<>(Integer::compareTo);
        sls2.add(5);
        sls2.add(10);
        sls2.add(15);
        sls2.add(25);
        sls2.add(30);
        System.out.println(sls2.toString());
        System.out.println(sls2.remove(15));
        System.out.println(sls2.toString()+ "este es el conjunto despues de eliminar un elemento");
        
        System.out.println("Conjunto C = AUB");
        SLSet<Integer> sls3 =sls.union(sls2);
        System.out.println(sls3.toString());
        
        System.out.println("Conjunto D= A interseccion B");
        SLSet<Integer> sls4 =sls.intersection(sls2);
        System.out.println(sls4.toString());
        
        System.out.println("Conjunto D= A-B");
        SLSet<Integer> sls5 =sls.difference(sls2);
        System.out.println(sls5.toString());
        
        
    }
}
