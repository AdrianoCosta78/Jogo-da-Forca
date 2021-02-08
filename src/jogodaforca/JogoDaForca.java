/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class JogoDaForca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Sorteador
        Random random = new Random();

        //Scanner
        Scanner in = new Scanner(System.in);

        //Lista de Palavras
        String[] palavras = {"ORTODOXO", "PALAVRA", "MACARRONADA", "COMPLEXIDADE", "CAVALEIRO", "FEITICEIRA"};

        //Quantidade de Palavras
        int quantPalavras = palavras.length;//length pega o tamanho do vetor
        int indiceSorteado = random.nextInt(quantPalavras);//posição no vetor da palavra sorteada
        String sorteada = palavras[indiceSorteado];//A Palavra Sorteada

        //System.out.println(palavras[indiceSorteado]);
        //controlar os acertos do usuário, 
        char[] acerto = new char[sorteada.length()];
        for (int i = 0; i < acerto.length; i++) {
            acerto[i] = 0;
        }

        String letrasUtilizadas = "";

        char letra;
        boolean ganhou = false;
        int vidas = 5; //Quandidade de vidas do jogador

        //System.out.println(sorteada);//Palavra sorteada
        for (int i = 0; i < sorteada.length(); i++) {
            System.out.print(" _ ");
        }

        while (!ganhou && vidas > 0) {//!=não

            System.out.println("\n"
                    + "Você tem " + vidas + " vidas"
                    + "\nLetras utilizadas: " + letrasUtilizadas
                    + "\nQual letra vc deseja tentar?");

            letra = in.next().toUpperCase().charAt(0);
            letrasUtilizadas += " " + letra;

            boolean perdeVida = true;
            for (int i = 0; i < sorteada.length(); i++) {

                if (letra == sorteada.charAt(i)) {
                    //  System.out.println("Tem essa letra na posição " + i);
                    acerto[i] = 1;
                    perdeVida = false;
                }

            }

            if (perdeVida) {
                vidas--;
            }

            System.out.println("\n");
            ganhou = true;
            for (int i = 0; i < sorteada.length(); i++) {
                if (acerto[i] == 0) {
                    System.out.print(" _ ");
                    ganhou = false;
                } else {
                    System.out.print(" " + sorteada.charAt(i) + " ");
                }

            }
            System.out.println("\n");
        }
        if (vidas != 0) {
            System.out.println("\nParabéns vc acertou!!!");
        } else {
            System.out.println("\n\t Você perdeu!!!");
            System.out.println("A palavra era: " + sorteada);
        }

    }
}
