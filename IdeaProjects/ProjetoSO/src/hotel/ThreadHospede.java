package hotel;

import org.omg.CORBA.Current;

import java.util.Locale;
import java.util.concurrent.Semaphore;

public class ThreadHospede extends Thread {
    private Hospede hospede;
//    private Televisao televisao;
    private int canal;
    private int canalAssistido;
    private Semaphore semaphore;
    Semaphore mutex = new Semaphore(0);



    public ThreadHospede(Hospede hospede, Semaphore semaphore, int canalAssistido) {
        this.semaphore = semaphore;
        this.hospede = hospede;
//        this.televisao = televisao;
//        this.canal = canal;
        this.canalAssistido = canalAssistido;
    }

    @Override
    public void run() {
        while(true){

            this.assisteTv(hospede);
            this.descansaTv(hospede);

        }


    }

    private void assisteTv(Hospede hospede) {
        System.out.println("Hóspede");
        String nome = Thread.currentThread().getName();
        int tempo;

        try {
            long i = 0;
            canal++;
            try{
                if (this.canalAssistido==0 || this.hospede.getCanal()==this.canalAssistido) {
                }else{
                    mutex.acquire();
                }
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            if (!(canal==0 || this.canal == (canal))) {
////                    dormindo(nome);
//
//            }else{
                if(this.hospede.getCanal()==canalAssistido){
                    while (hospede.getTempoTv() > i) {
                        tempo = hospede.getTempoTv();
                        System.out.println("O " + nome.toLowerCase(Locale.ROOT) + " assistiu o canal "+ hospede.getCanal() +" tv por " + (i + 1) + " segundos.");
                        Thread.sleep(1000);
                        i++;
                        tempo --;
                    }
                    semaphore.release();
                    canal--;
                    if(canal>0) {
                    }else{
                        mutex.release();
                    }

                }else{

                    tempo = hospede.getTempoTv();
                    while (tempo > i) {
                        System.out.println("O " + nome.toLowerCase(Locale.ROOT) + " assistiu tv por " + (i + 1) + " segundos.");
                        Thread.sleep(1000);
                        i++;
                    }
                    semaphore.release();
                }
//            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void descansaTv(Hospede hospede) {
        try {
            long i = 0;
            while(hospede.getTempoDescansar()> i) {
                System.out.println("O hospede "+ hospede.getId() +" está descansando.");
                Thread.sleep(1000);
                i++;
            }
            System.out.println("O hospede "+ hospede.getId() +" está descansou.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
