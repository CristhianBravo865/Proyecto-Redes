import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorNumerico extends JFrame implements ActionListener {

    private JTextField entrada;
    private JLabel resultadoLabel;
    private JButton convertirBtn;

    public ConversorNumerico() {
        setTitle("Conversor Numérico");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        entrada = new JTextField();
        resultadoLabel = new JLabel("Resultado: ");
        convertirBtn = new JButton("Convertir");

        add(entrada);
        add(convertirBtn);
        add(resultadoLabel);

        convertirBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertirBtn) {
            String entradaText = entrada.getText();

            if (entradaText.isEmpty()) {
                resultadoLabel.setText("Resultado: ");
                return;
            }

            try {
                long decimal = 0;
                int base = 10; // Base decimal por defecto

                if (entradaText.startsWith("0x")) {
                    base = 16;
                    entradaText = entradaText.substring(2);
                } else if (entradaText.startsWith("0b")) {
                    base = 2;
                    entradaText = entradaText.substring(2);
                } else if (entradaText.startsWith("0")) {
                    base = 8;
                    entradaText = entradaText.substring(1);
                }

                decimal = Long.parseLong(entradaText, base);
                resultadoLabel.setText("Resultado: " + decimal + " (Base 10)");
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Entrada inválida");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorNumerico conversor = new ConversorNumerico();
            conversor.setVisible(true);
        });
    }
}
