//package hotel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.concurrent.Semaphore;
//
//public class GUI implements ActionListener{
////    private static JFrame frame;
////    private static JPanel panel;
////    private static JLabel idLabel;
//      private static JTextField idText;
////    private static JLabel canalLabel;
////    private static JTextField canalText;
////    private static JLabel tempoAssistirLabel;
////    private static JTextField tempoAssistirText;
////    private static JLabel tempoDescansarLabel;
////    private static JTextField tempoDescansarText;
//
//    public GUI(){
//        JPanel panel = new JPanel();
////        frame = new JFrame();
//
////        frame.setSize(350, 200);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setVisible(true);
////        frame.setTitle("Teste 1");
////        frame.pack();
////
////
////
////        frame.add(panel, BorderLayout.CENTER);
////        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//        panel.setLayout(new GridLayout(2, 2));
//
//        // Labels
//        //Id
//        JLabel idLabel = new JLabel("Id hospede: ");
//        idLabel.setBounds(10, 20, 80, 25);
//        panel.add(idLabel);
//        JTextField idText = new JTextField(20);
//        idText.setBounds(10,20,100, 25);
//        panel.add(idText);
////        //canal
////        canalLabel = new JLabel("Canal do hospede: ");
////        canalLabel.setBounds(10, 20, 80, 25);
////        panel.add(canalLabel);
////        canalText = new JTextField(20);
////        idText.setBounds(100,20,165, 25);
////        panel.add(idText);
//
////        //Assistir
////        tempoAssistirLabel = new JLabel("Tempo assistindo do hospede: ");
////        tempoAssistirLabel.setBounds(10, 20, 80, 25);
////        panel.add(tempoAssistirLabel);
////        tempoAssistirText = new JTextField(20);
////        idText.setBounds(100,20,165, 25);
////        panel.add(idText);
////
////        //Descansar
////        tempoDescansarLabel = new JLabel("Tempo descansando do hospede: ");
////        tempoDescansarLabel.setBounds(10, 20, 80, 25);
////        panel.add(tempoDescansarLabel);
////        tempoDescansarText = new JTextField(20);
////        tempoDescansarText.setBounds(100,20,165, 25);
////        panel.add(tempoDescansarText);
//
//        JButton jButton = new JButton("Adicionar");
//        jButton.setBounds(10, 80, 80, 25);
//        jButton.addActionListener(this::actionPerformed);
//        panel.add(jButton);
//
////        frame.add(panel, BorderLayout.CENTER);
//
//
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Hospede hospede = new Hospede();
//        hospede.setId(Integer.parseInt(idText.getText()));
////        hospede.setCanal(Integer.parseInt(canalText.getText()));
////        hospede.setTempoTv(Integer.parseInt(tempoAssistirText.getText()));
////        hospede.setTempoDescansar(Integer.parseInt(tempoDescansarText.getText()));
//        Semaphore semaphore = new Semaphore(1);
//        String nomeThread = "Hóspede" + hospede.getId();
//        Televisao televisao = new Televisao();
//        Thread hospedeThread = new Thread(new ThreadHospede(televisao, hospede, semaphore), "Hospede " + hospede.getId());
//        hospedeThread.start();
//
//
//
//    }
//}