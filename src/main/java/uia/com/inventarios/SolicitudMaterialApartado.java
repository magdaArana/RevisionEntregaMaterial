package uia.com.inventarios;

import java.io.IOException;

public class SolicitudMaterialApartado extends SolicitudSalidaMaterial
{
    public SolicitudMaterialApartado(InfoInventarioUIA sm) throws IOException {
        super(sm);
    }

    public SolicitudMaterialApartado(int id, String name, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria) {
        super(id, name, categoria, cantidad, idPartida, idSubpartida, idCategoria);
    }

    public void serializa(String nombre) throws IOException {
        super.serializa(nombre);
    }
}
