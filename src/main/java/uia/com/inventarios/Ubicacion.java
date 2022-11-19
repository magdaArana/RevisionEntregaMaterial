package uia.com.inventarios;

public class Ubicacion {
    String posicion="SinPosicion";
    String Estatus="SinEstatus";

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public Ubicacion() {
    }

    public Ubicacion(String posicion, String estatus) {
        this.posicion = posicion;
        Estatus = estatus;
    }
}
