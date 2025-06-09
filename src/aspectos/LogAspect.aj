package aspectos;

import java.awt.Color;

public aspect LogAspect {

    pointcut cambioColor(Color c): 
        execution(void app.Main.cambiarColor(Color)) && args(c);

    after(Color c): cambioColor(c) {
        String colorTexto = "";

        if (Color.RED.equals(c)) {
            colorTexto = "Rojo";
        } else if (Color.GREEN.equals(c)) {
            colorTexto = "Verde";
        } else if (Color.BLUE.equals(c)) {
            colorTexto = "Azul";
        } else {
            colorTexto = "Otro color";
        }

        System.out.println("Color cambiado a: " + colorTexto);
    }
}