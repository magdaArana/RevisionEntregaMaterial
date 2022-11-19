package uia.com.inventarios;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorSalida
{
    List<SolicitudSalidaMaterial> items = new ArrayList<SolicitudSalidaMaterial>();
    private NivelInventario reporteInventario;
    GestorApartado gestorApartado;

    public GestorSalida(int id, String name, String descripcion, String cantidad, String partida, String subpartida, String categoria) throws IOException {
    }

    public GestorSalida() throws IOException {
        this.gestorApartado = new GestorApartado();
    }

    public GestorSalida(String nombreDB) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            reporteInventario = mapper.readValue(new FileInputStream(nombreDB), NivelInventario.class );
        }catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (reporteInventario != null)
        {
            System.out.println("----- Items List -----");
            for (Map.Entry<String, InfoItem> item : reporteInventario.getItems().entrySet())
            {
                PartidaInventario nodo = (PartidaInventario) item.getValue();
                nodo.print();
            }
        }
    }


    public void serializa(SolicitudSalidaMaterial newSSM) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("solicitudSalidaMaterial-4.json"), newSSM);
    }


    public void agregaSolicitudSalidaMaterial(String solicitante, String categoria, String nombre, String descripcion, String cantidad, String idPartida, String idSubpartida, String idCategoria) throws IOException
    {
        int id = this.getItems().size()+1;

        String existencia = "";
        List<InfoItem> items = reporteInventario.busca(id, descripcion, categoria, cantidad, idPartida, idSubpartida, idCategoria);
        if(items.size() > 0)
        {
            System.out.println("Existen "+existencia+"  "+ categoria +"en inventario");
            SolicitudSalidaMaterial newSSM = new SolicitudSalidaMaterial(id, solicitante, categoria, "", "", "", "");
            newSSM.setItems(items);
            newSSM.setEstatus("Apartado");
            this.serializa(newSSM);
            if(this.gestorApartado == null)
                this.gestorApartado = new GestorApartado();
            gestorApartado.agregaSolicitudMaterialApartado(newSSM);

            reporteInventario.serializa();
        }
    }

    public List<SolicitudSalidaMaterial> getItems() {
        return items;
    }

    public void setItems(List<SolicitudSalidaMaterial> items) {
        this.items = items;
    }

    public NivelInventario getReporteInventario() {
        return reporteInventario;
    }

    public void setReporteInventario(NivelInventario reporteInventario) {
        this.reporteInventario = reporteInventario;
    }

    public GestorApartado getGestorApartado() {
        return gestorApartado;
    }

    public void setGestorApartado(GestorApartado gestorApartado) {
        this.gestorApartado = gestorApartado;
    }


}
