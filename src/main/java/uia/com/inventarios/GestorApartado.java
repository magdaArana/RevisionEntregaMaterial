package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorApartado
{
    List<SolicitudSalidaMaterial> items = new ArrayList<SolicitudSalidaMaterial>();

    public GestorApartado() throws IOException {
        super();
    }

    public void agregaSolicitudMaterialApartado(SolicitudSalidaMaterial newSSM) throws IOException {
        newSSM.setEstatus("Apartado");
        this.getItems().add(newSSM);
        this.serializa("SolicitudesApartadoMaterial-1.json");
    }

    public List<SolicitudSalidaMaterial> getItems() {
        return items;
    }

    public void setItems(List<SolicitudSalidaMaterial> items) {
        this.items = items;
    }

    protected void serializa(String nombre) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(nombre), this);
    }
    public void condicionesMaterial(SolicitudSalidaMaterial newSSM){
        System.out.println(newSSM.getEstatus());
    }
}
