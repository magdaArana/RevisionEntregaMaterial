package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartidaInventario.class, name = "Partida"),
        @JsonSubTypes.Type(value = SubpartidaInventario.class, name = "Subpartida"),
        @JsonSubTypes.Type(value = CategoriaInventario.class, name = "Categoria"),
        })



public class InfoItem {
    private String id;
    private String name;
    //private List<InfoItem> items = new ArrayList<InfoItem>();
    private HashMap<String, InfoItem> items = new HashMap<String, InfoItem>();
    private String estatus = "sinEstatus";
    private Ubicacion ubicacion = new Ubicacion();

    public InfoItem(String idPartida, String descPartida, String sinEstatus)
    {
        this.id = id;
        this.name = name;
        this.estatus = estatus;
    }

    public InfoItem(String idItem, String descCat, String sinEstatus, String s, String ubic)
    {
        this.id = idItem;
        this.name = descCat;
        this.estatus = sinEstatus;
        ubicacion.setPosicion(ubic);
    }


    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }


    public InfoItem(String id, String name, String estatus, String ubic) {
        this.id = id;
        this.name = name;
        this.estatus = estatus;
        ubicacion.setPosicion(ubic);
    }

    public InfoItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, InfoItem> getItems() {
        return items;
    }

    public void setItems(HashMap<String, InfoItem> items) {
        this.items = items;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }



    public void print()
    {
        if (this.getItems().size() > 0)
        {
            System.out.println("----- Items List -----");

            for (Map.Entry<String, InfoItem> item : this.getItems().entrySet())
            {
                InfoItem nodo =  item.getValue();
                nodo.print();
            }
        }
        else {
            System.out.println(this);
            System.out.println("Id:\t" + this.getId());
            System.out.println("Name:\t" + this.getName());
            System.out.println("Estatus:\t" + this.getEstatus());
        }

    }

    public List<InfoItem> getItems(String cantidad)
    {
        int cantidadInt = Integer.parseInt(cantidad);

        List<InfoItem> itemsTemp = new ArrayList<InfoItem>();
        for (Map.Entry<String, InfoItem> item : this.getItems().entrySet())
        {
            InfoItem nodo =  item.getValue();
            if(nodo.getEstatus().contentEquals("SinEstatus") && cantidadInt>0)
            {
                nodo.setEstatus("Apartado");
                itemsTemp.add(nodo);
                --cantidadInt;
            }
            nodo.print();
        }
        return itemsTemp;
    }
}
