package ejercicioJSON.repository;

import ejercicioJSON.interfaces.InPutBBDD;
import ejercicioJSON.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class BBDDReadPersonas extends ConnBBDDPersonas implements InPutBBDD {
    public BBDDReadPersonas() {

    }

    @Override
    public List<Persona> read() {
        List<Persona> personas = new ArrayList<>();



        return personas;
    }
}
