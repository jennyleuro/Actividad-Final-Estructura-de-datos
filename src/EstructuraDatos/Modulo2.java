package EstructuraDatos;

public class Modulo2 {
    private String estado = "Desocupado";

    public int ocupado(int tiempoIngreso, int tiempoEjecucion){
        int tiempoFinal = tiempoIngreso + tiempoEjecucion;
        this.estado = "Ocupado";
        return tiempoFinal;

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
