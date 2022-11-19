package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SolicitudSalidaMaterial extends InfoInventarioUIA {

    public SolicitudSalidaMaterial(InfoInventarioUIA sm) throws IOException {
        super();
    }

    public SolicitudSalidaMaterial(int id, String name, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria)
    {
        super(id, name, categoria, cantidad, idPartida, idSubpartida, idCategoria);
    }

    public SolicitudSalidaMaterial(String s) {
    }

    public void serializa(String nombre) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(nombre), this);
    }
    public void revisarSolicitudMaterial(){
        System.out.println("revision");

    }
}