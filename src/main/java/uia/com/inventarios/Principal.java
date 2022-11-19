package uia.com.inventarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Principal {

    public static void main(String[] args) throws IOException {
        System.out.println("Hola UIA");

        /*
        //funcionalidad transitoria para construcción del reporte de nivel de inventario
        NivelInventario inventario = new NivelInventario();
        inventario.agrega("100","Material Oficina","110","Sillas","111","Silla ejecutiva clase 1", "3");
        inventario.agrega("100","Material Oficina","110","Sillas","112","Silla ejecutiva clase 2", "3");
        inventario.agrega("100","Material Oficina","110","Sillas","113","Silla secretarial clase 1", "3");
        inventario.agrega("100","Material Oficina","110","Sillas","114","Silla secretarial clase 2", "3");
        inventario.agrega("100","Material Oficina","110","Sillas","115","Silla de espera ", "3");
        inventario.agrega("100","Material Oficina","120","Mesas","121","Mesa ejecutivo clase 1", "4");
        inventario.agrega("100","Material Oficina","120","Mesas","122","Mesa ejecutivo clase 2", "4");
        inventario.agrega("200","Material Oficina","120","Mesas","123","Mesa secretarial clase 1", "5");
        inventario.serializa();
        ItemInventarioUIA info9 = new InfoInventario("9","100","Material Oficina","120","Mesas","124","Mesa secretarial clase 2");
        ItemInventarioUIA info10 = new InfoInventario("10","100","Material Oficina","120","Mesas","125","Mesa de espera ");
        ItemInventarioUIA info11 = new InfoInventario("11","100","Material Oficina","130","Escritorios","131","Escritorio ejecutivo clase 1");
        ItemInventarioUIA info12 = new InfoInventario("12","100","Material Oficina","130","Escritorios","132","Escritorio ejecutivo clase 2");
        ItemInventarioUIA info13 = new InfoInventario("13","100","Material Oficina","130","Escritorios","133","Escritorio secretarial clase 1");
        ItemInventarioUIA info14 = new InfoInventario("14","100","Material Oficina","130","Escritorios","134","Escritorio secretarial clase 2");
        ItemInventarioUIA info15 = new InfoInventario("15","100","Material Oficina","130","Escritorios","135","Escritorio de espera ");
        ItemInventarioUIA info16 = new InfoInventario("16","100","Material Oficina","140","Libreros","141","Librero ejecutivo clase 1");
        ItemInventarioUIA info17 = new InfoInventario("17","100","Material Oficina","140","Libreros","142","Librero ejecutivo clase 2");
        ItemInventarioUIA info18 = new InfoInventario("18","100","Material Oficina","140","Libreros","143","Librero secretarial clase 1");
        ItemInventarioUIA info19 = new InfoInventario("19","100","Material Oficina","140","Libreros","144","Librero secretarial clase 2");
        ItemInventarioUIA info20 = new InfoInventario("20","100","Material Oficina","140","Libreros","145","Librero de espera ");
        ItemInventarioUIA info21 = new InfoInventario("21","100","Material Oficina","150","Archiveros ","151","Archivero ejecutivo clase 1");
        ItemInventarioUIA info22 = new InfoInventario("22","100","Material Oficina","150","Archiveros ","152","Archivero ejecutiva clase 2");
        ItemInventarioUIA info23 = new InfoInventario("22","100","Material Oficina","150","Archiveros ","153","Archivero secretarial clase 1");
        ItemInventarioUIA info24 = new InfoInventario("23","100","Material Oficina","150","Archiveros ","154","Archivero secretarial clase 2");
        ItemInventarioUIA info25 = new InfoInventario("24","100","Material Oficina","150","Archiveros ","155","Archivero de espera ");



         */
        GestorSalida gestor = new GestorSalida("ReporteNivelInventario-5.json");

        gestor.agregaSolicitudSalidaMaterial(
                                            "Sebastian ",
                                            "Alumno TSU",
                                            "Solicitud de Material",
                                            "Silla ejecutiva clase 2\n",
                                            "3",
                                            "100",
                                            "110",
                                            "112");

        SolicitudSalidaMaterial solicitudSalidaMaterial = new SolicitudSalidaMaterial("solicitudSalidaMaterial-4.json");
        solicitudSalidaMaterial.revisarSolicitudMaterial();





        SpringApplication.run(Principal.class, args);
    }

}
