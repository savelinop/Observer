package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
    	setTitle("AspectJ Observer Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton redButton = new JButton("Rojo");
        JButton greenButton = new JButton("Verde");
        JButton blueButton = new JButton("Azul");

        panel.add(redButton);
        panel.add(greenButton);
        panel.add(blueButton);

        getContentPane().setLayout(new BorderLayout()); // <-- nuevo
        getContentPane().add(panel, BorderLayout.NORTH); // <-- nuevo

        redButton.addActionListener(new ColorChanger(this, Color.RED));
        greenButton.addActionListener(new ColorChanger(this, Color.GREEN));
        blueButton.addActionListener(new ColorChanger(this, Color.BLUE));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    public void cambiarColor(Color color) {
        getContentPane().setBackground(color);
        repaint();
    }
}

class ColorChanger implements ActionListener {
    private Main ventana;
    private Color color;

    public ColorChanger(Main ventana, Color color) {
        this.ventana = ventana;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.cambiarColor(color);
    }
}
