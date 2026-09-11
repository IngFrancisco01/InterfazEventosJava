import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazEventos extends Frame implements ActionListener {

    private Button botonMover;
    private Button botonCalcular;
    private Button botonContador;

    private TextField campoNumero;
    private TextField campoResultado;
    private TextField campoContador;

    private int contador = 0;

    public InterfazEventos() {

        // ---------- Ventana principal ----------
        setTitle("Semana 3 - Eventos Java");
        setSize(600, 450);
        setLayout(null);
        setBackground(new Color(235, 242, 250));

        // ---------- Título ----------
        Label titulo = new Label("SEMANA 3 - EVENTOS JAVA", Label.CENTER);
        titulo.setBounds(50, 25, 500, 40);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        titulo.setForeground(new Color(35, 55, 85));
        add(titulo);

        // ---------- Subtítulo ----------
        Label subtitulo = new Label(
                "Manejo de eventos e interacción con la interfaz",
                Label.CENTER);
        subtitulo.setBounds(70, 65, 460, 25);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(new Color(80, 95, 115));
        add(subtitulo);

        // ---------- Panel principal ----------
        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBounds(40, 105, 520, 290);
        panel.setBackground(Color.WHITE);
        add(panel);

        // ---------- Sección mover botón ----------
        Label tituloMover = new Label("EVENTO DE MOVIMIENTO");
        tituloMover.setBounds(25, 15, 250, 25);
        tituloMover.setFont(new Font("SansSerif", Font.BOLD, 13));
        tituloMover.setForeground(new Color(45, 70, 105));
        panel.add(tituloMover);

        botonMover = new Button("Mover botón");
        botonMover.setBounds(25, 50, 140, 40);
        botonMover.setBackground(new Color(70, 130, 180));
        botonMover.setForeground(Color.WHITE);
        botonMover.setFont(new Font("SansSerif", Font.BOLD, 12));
        botonMover.addActionListener(this);
        panel.add(botonMover);

        // ---------- Sección cálculo ----------
        Label tituloCalculo = new Label("CÁLCULO DEL CUADRADO");
        tituloCalculo.setBounds(25, 105, 250, 25);
        tituloCalculo.setFont(new Font("SansSerif", Font.BOLD, 13));
        tituloCalculo.setForeground(new Color(45, 70, 105));
        panel.add(tituloCalculo);

        Label etiquetaNumero = new Label("Número:");
        etiquetaNumero.setBounds(25, 140, 70, 25);
        etiquetaNumero.setFont(new Font("SansSerif", Font.BOLD, 12));
        panel.add(etiquetaNumero);

        campoNumero = new TextField();
        campoNumero.setBounds(95, 140, 110, 25);
        panel.add(campoNumero);

        botonCalcular = new Button("Calcular cuadrado");
        botonCalcular.setBounds(220, 140, 150, 25);
        botonCalcular.setBackground(new Color(76, 175, 80));
        botonCalcular.setForeground(Color.WHITE);
        botonCalcular.setFont(new Font("SansSerif", Font.BOLD, 11));
        botonCalcular.addActionListener(this);
        panel.add(botonCalcular);

        Label etiquetaResultado = new Label("Resultado:");
        etiquetaResultado.setBounds(25, 175, 70, 25);
        etiquetaResultado.setFont(new Font("SansSerif", Font.BOLD, 12));
        panel.add(etiquetaResultado);

        campoResultado = new TextField();
        campoResultado.setBounds(95, 175, 110, 25);
        campoResultado.setEditable(false);
        campoResultado.setBackground(new Color(235, 248, 238));
        panel.add(campoResultado);

        // ---------- Sección contador ----------
        Label tituloContador = new Label("CONTADOR DE EVENTOS");
        tituloContador.setBounds(25, 215, 200, 25);
        tituloContador.setFont(new Font("SansSerif", Font.BOLD, 13));
        tituloContador.setForeground(new Color(45, 70, 105));
        panel.add(tituloContador);

        botonContador = new Button("Contar clic");
        botonContador.setBounds(25, 245, 120, 30);
        botonContador.setBackground(new Color(156, 85, 180));
        botonContador.setForeground(Color.WHITE);
        botonContador.setFont(new Font("SansSerif", Font.BOLD, 11));
        botonContador.addActionListener(this);
        panel.add(botonContador);

        Label etiquetaContador = new Label("Clics:");
        etiquetaContador.setBounds(170, 245, 45, 30);
        etiquetaContador.setFont(new Font("SansSerif", Font.BOLD, 12));
        panel.add(etiquetaContador);

        campoContador = new TextField("0");
        campoContador.setBounds(215, 245, 70, 30);
        campoContador.setEditable(false);
        campoContador.setFont(new Font("SansSerif", Font.BOLD, 14));
        campoContador.setBackground(new Color(245, 238, 250));
        panel.add(campoContador);

        // ---------- Cerrar ventana ----------
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Evento: mover botón
        if (e.getSource() == botonMover) {
            botonMover.setBounds(340, 50, 140, 40);
        }

        // Evento: calcular cuadrado
        if (e.getSource() == botonCalcular) {

            String texto = campoNumero.getText().trim();

            try {
                double numero = Double.parseDouble(texto);
                double cuadrado = numero * numero;

                campoResultado.setText(String.valueOf(cuadrado));

            } catch (NumberFormatException ex) {
                campoResultado.setText("Número inválido");
            }
        }

        // Evento: contador de clics
        if (e.getSource() == botonContador) {

            contador++;

            campoContador.setText(String.valueOf(contador));
        }
    }

    public static void main(String[] args) {
        new InterfazEventos();
    }
}