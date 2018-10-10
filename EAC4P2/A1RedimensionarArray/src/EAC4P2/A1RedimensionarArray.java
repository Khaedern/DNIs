/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EAC4P2;

import java.util.Scanner;

/**
 *
 * @author Alex Chinchilla
 */
public class A1RedimensionarArray {

    

    String dniDemanat = "";
    int midaArray=1;

    public static void main(String[] args) {
        // TODO code application logic here
        //adapteu la instanciació del programa d'acord amb el fitxer on treballeu

        A1RedimensionarArray prg = new A1RedimensionarArray();
        prg.inici();
    }

    //Programa principal. Anirà demanat dni's fins que introuint un 0 
    private void inici() {
        int i=0;
        String[] arrayDNI = new String[1];
        String[] nouArrayDni = new String[arrayDNI.length + i];
        String dniIntroduit = demanarString();
        while (!dniIntroduit.contentEquals("0")) {
            dniIntroduit=demanarString();
            if (!dniIntroduit.contentEquals("0")) {
                arrayDNI[i]=dniIntroduit;
                //buscarDNI(dniIntroduit, arrayDNI);

                if (!buscarDNI(dniIntroduit, arrayDNI)) {
                    arrayDNI = guardarDNI(arrayDNI, dniIntroduit);
                    
                    mostrarArrayDNI(arrayDNI);
                    i++;
                } else {
                    System.out.println("DNI " + dniIntroduit + " ja existeix");
                }
            }
        }

        System.out.println("El programa ha finalitzat amb els següents DNIs introduïts:");
        mostrarArrayDNI(arrayDNI);
    }

    //funcio que permet guardar el dni nou redimensionant l'array 1 posició més
    String[] guardarDNI(String[] dnis, String nouDNI) {
        int mida = dnis.length;
        String[] nouArrayDni = new String[mida + 1];
        for (int i = 0; i < dnis.length; i++) {
            nouArrayDni[i] = dnis[i];
        }
        
        nouArrayDni[dnis.length + 1] = nouDNI;
        return nouArrayDni;
    }

    //Aquesta funció demana un String i si la entrada és buida dona un missatge i 
    //no deixa entrar valors buits. 
    private String demanarString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduïu DNI 8 números i una lletra (99999999L)");
        dniDemanat = scanner.nextLine();
        while (dniDemanat.isEmpty()) {
            System.out.println("No s'admet dni buits, per sortir escriu 0");
            System.out.println("Introduïu DNI 8 números i una lletra (99999999L)");
            dniDemanat = scanner.nextLine();
        }
        return dniDemanat;
    }

    //Funció que buscar si el dni introduit està repetit  
    private boolean buscarDNI(String nouDNI, String[] llistaDNI) {
        boolean dniTrobat = false;
        for (int x = 0; x < llistaDNI.length; x++) {
            if (llistaDNI[x].equals(nouDNI)) {
                dniTrobat = true;
            }
        }
        return dniTrobat;
    }

    //l'array del tots els dni's 
    private void mostrarArrayDNI(String[] arrayDNI) {
        System.out.println("\nDNI Introduïts");
        System.out.println("--------------");
        for (int x = 0; x < arrayDNI.length; x++) {
            System.out.println(arrayDNI[x]);
        }
        System.out.println("\n");
    }

}
