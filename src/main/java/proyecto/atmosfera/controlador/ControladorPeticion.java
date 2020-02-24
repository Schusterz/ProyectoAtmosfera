package proyecto.atmosfera.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
public class ControladorPeticion {

    @RequestMapping(value= "/obtenerFechaInicio", method = RequestMethod.GET)
    public ArrayList<Registro> enviarDatos(@RequestParam(name = "fechaInicio", required = true) String fecha){
        ManejoDato manejoDato = new ManejoDato();
        ControlRegistro controlRegistro = new ControlRegistro();
        ArrayList<Registro> registros = manejoDato.leerArchivo("src/archivos/Historial_SmartCity_2019.csv");
        ArrayList<Registro> datosFinales = controlRegistro.binarySearch(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")),registros);
        return datosFinales;
    }

}
