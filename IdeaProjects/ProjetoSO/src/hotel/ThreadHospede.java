package hotel;

import org.omg.CORBA.Current;

import java.util.concurrent.Semaphore;

public class ThreadHospede extends Thread {
    private Hospede hospede;
    private Televisao televisao;
    private int canal;
    private int canalAssistido;
    private Semaphore semaphore;


    public ThreadHospede(Televisao televisao, Hospede hospede, Semaphore semaphore, int canal, int canalAssistido) {
        this.semaphore = semaphore;
        this.hospede = hospede;
        this.televisao = televisao;
        this.canal = canal;
        this.canalAssistido = canalAssistido;
    }

    @Override
    public void run() {



            try{
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            televisao.assisteTv(hospede);

            if (canal == 0){
                canalAssistido = 0;
            }

            semaphore.release();
            canal--;
            televisao.descansaTv(hospede);


    }
}
