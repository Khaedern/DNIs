/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac4p1;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class A1IntroduirDNI {

    /*
     * @param args the command line arguments
     */
    static final int MAXIM_ARRAY = 10;
    String[] arrayDNI=new String[MAXIM_ARRAY];
    int numeroDniIntroduits=0;
    
    String dniDemanat="";
    boolean dniTrobat = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
     //adapteu la instanciació del programa d'acord amb el fitxer on treballeu
        A1IntroduirDNI prg = new A1IntroduirDNI();
        prg.inici();
    }
    
    //Programa principal. Anirà demanat dni's fins que introuint un 0 o omplint l'array de 10 posicions
    private void inici(){
       
        while (!dniDemanat.contentEquals("0")&& numeroDniIntroduits< MAXIM_ARRAY) {
                    demanarString();
                    if(!dniDemanat.contentEquals("0")){
                        buscarCoincidencies();
                        
                        if (!dniTrobat){
                            arrayDNI[numeroDniIntroduits]=dniDemanat;
                            numeroDniIntroduits++;
                            mostrarArrayDNI();
                        }else{
                            System.out.println("DNI " +dniDemanat+" ja existeix");
                        }
                    }
            }
        
        System.out.println("El programa ha finalitzat amb els següents DNIs introduïts:");
        mostrarArrayDNI();
    }
    
    //Aquesta funció emana un String i si la entrada és buida dona un missatge i 
    //no deixa entrar valors buits. 
    private void demanarString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduïu DNI 8 números i una lletra (99999999L)");
        dniDemanat = scanner.nextLine();
        while (dniDemanat.isEmpty()){
            System.out.println("No s'admet dni buits, per sortir escriu 0");
            System.out.println("Introduïu DNI 8 números i una lletra (99999999L)");
            dniDemanat = scanner.nextLine();
        }
    }
    
    //Funcióque buscar si el dni introduit està repetit  
    private void buscarCoincidencies(){
        dniTrobat=false;
        for (int x=0;x<numeroDniIntroduits;x++){
             if (arrayDNI[x].equals(dniDemanat)){
                 dniTrobat=true;
            }
        }
    }
    
    //l'array del tots els dni's 
    private void mostrarArrayDNI(){
     System.out.println("\nDNI Introduïts");
     System.out.println("--------------");
     for (int x=0;x<numeroDniIntroduits;x++){
          System.out.println(arrayDNI[x]);
        }
     System.out.println("\n");
     }
    
}