package Exec;
import Bases.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Conversor de Bases");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 200);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JPanel outputPanel = new JPanel(new BorderLayout());
        JLabel labelBaseNum = new JLabel("Base del número inicial (10, 2, 8, 16):");
        JTextField BaseNumField = new JTextField(5);
        JLabel labelNumero = new JLabel("Número:");
        JTextField numeroField = new JTextField(10);
        JButton botonConvertir = new JButton("Convertir");
        JTextArea resultados = new JTextArea(10, 20);
        resultados.setEditable(false);

        inputPanel.add(labelBaseNum);
        inputPanel.add(BaseNumField);
        inputPanel.add(labelNumero);
        inputPanel.add(numeroField);
        inputPanel.add(new JLabel());
        inputPanel.add(botonConvertir);
        outputPanel.add(new JScrollPane(resultados), BorderLayout.CENTER);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(outputPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String  cbase1 = BaseNumField.getText();
                String  numero = numeroField.getText();
                Base base1 = null; 
                try {
                    if (cbase1.equals("10")) {
                        base1 = new Decimal(numero);
                    } 
                    else if (cbase1.equals("2")) {
                        base1 = new Binario(numero);
                    } 
                    else if (cbase1.equals("8")) {
                        base1 = new Octal(numero);
                    } 
                    else if (cbase1.equals("16")) {
                        base1 = new Hexadecimal(numero);
                    } 
                    else {
                        resultados.setText("Base no válida. Debe ser 10, 2, 8 o 16.");
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    resultados.setText(e.getMessage());
                    return;
                }

                String cbase2 = JOptionPane.showInputDialog("A qué base desea transformar " + base1 + " (10, 2, 8, 16)?");

                        try {
                            if (cbase2.equals("10")) {
                                resultados.setText(String.valueOf(base1.convertirDecimal()));
                            } else if (cbase2.equals("2")) {
                                resultados.setText(base1.convertirBinario());
                            } else if (cbase2.equals("8")) {
                                resultados.setText(base1.convertirOctal());
                            } else if (cbase2.equals("16")) {
                                resultados.setText(base1.convertirHexadecimal());
                            } else {
                                resultados.setText("Base de salida no válida. Debe ser 10, 2, 8 o 16.");
                            }
                        } catch (IllegalArgumentException e) {
                            resultados.setText(e.getMessage());
                        }
                    }
                });
        }
}

