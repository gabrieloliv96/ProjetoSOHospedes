package hotel;

import java.util.Locale;

public class Televisao {
    private String canal = null;
    private int tempo;

    public void assisteTv(Hospede hospede) {
        System.out.println("Hóspede");
        String nome = Thread.currentThread().getName();



            try {
                long i = 0;
                if (!(canal==null || this.canal.equals(canal))) {
                    dormindo(nome);

                }else{
                    if(canal==null){
                        while (hospede.getTempoTv() > i) {
                            tempo = hospede.getTempoTv();
                            System.out.println("O " + nome.toLowerCase(Locale.ROOT) + " assistiu o canal "+ hospede.getCanal() +" tv por " + (i + 1) + " segundos.");
                            Thread.sleep(1000);
                            i++;
                            tempo --;
                        }

                    }else{

                        tempo = hospede.getTempoTv();
                        while (tempo > i) {
                            System.out.println("O " + nome.toLowerCase(Locale.ROOT) + " assistiu tv por " + (i + 1) + " segundos.");
                            Thread.sleep(1000);
                            i++;
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }

    private void dormindo(String nome) {
        System.out.println("Nhiame nhiame, que sonin...");
        try{
            this.wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void descansaTv(Hospede hospede) {
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
