package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {
//        new GUI();

        int qtdHosp = 0;
        Scanner ler = new Scanner(System.in);
        int count = 1;
        int id = 0;
        int canal;
        int tempoTv;
        int tempoDescanso;
        int canais = 1;
        int canalAssistido = 0;

        // Teste
//        System.out.println("Insira o id do hospede: ");
//        id = ler.nextInt();

//		for (int i=0; qtdHosp>i; i++) {

        // If para adicionar novo hospede
//			if( ) {
        while (true) {
            // Criando o hospede
            Hospede hospede = new Hospede();
            System.out.println("Insira o id do "+ count + " hospede: ");
            id = ler.nextInt();
            hospede.setId(id);
            System.out.println("Canal do hospede " + id + ": ");
            canal = ler.nextInt();
            count++;

            System.out.println("Tempo assistindo Tv (em segundos): ");
            tempoTv = ler.nextInt();
            System.out.println("Tempo descansando (em segundos): ");
            tempoDescanso = ler.nextInt();

            hospede.setCanal(canal);
            hospede.setTempoTv(tempoTv);
            hospede.setTempoDescansar(tempoDescanso);

//        System.out.println(hospede.getId());
//        System.out.println(hospede.getCanal());
//        System.out.println(hospede.getTempoTv());
//        System.out.println(hospede.getTempoDescansar());
//            Hospede hospede = new Hospede();
            if(canalAssistido==0 || canalAssistido==hospede.getCanal()) {
                canalAssistido = hospede.getCanal();
                canais++;
                Semaphore semaphore = new Semaphore(canais);
                String nomeThread = "Hóspede" + hospede.getId();
                Televisao televisao = new Televisao();
                Thread hospedeThread = new Thread(new ThreadHospede(televisao, hospede, semaphore, canais, canalAssistido), "Hospede " + hospede.getId());
                hospedeThread.start();

                canais--;
            }else {

                Semaphore semaphore = new Semaphore(canais);
                String nomeThread = "Hóspede" + hospede.getId();
                Televisao televisao = new Televisao();
                Thread hospedeThread = new Thread(new ThreadHospede(televisao, hospede, semaphore, canal, canalAssistido), "Hospede " + hospede.getId());
                hospedeThread.start();
            }
        }
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Instaciando a thread
//        Hospede hospede = new Hospede();
//        String nomeThread = "Hóspede" + hospede.getId();
//        Televisao televisao = new Televisao();
//        Thread hospedeThread = new Thread(new ThreadHospede(televisao, hospede), "Hospede " + hospede.getId());
//        hospedeThread.start();
//
//    }
}
