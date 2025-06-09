package aspectos;

public aspect ClickCounterAspect {

    private int contador = 0;

    pointcut colorCambiado(): execution(void app.Main.cambiarColor(..));

    after(): colorCambiado() {
        contador++;
        System.out.println("Total de cambios de color: " + contador);
    }
}
