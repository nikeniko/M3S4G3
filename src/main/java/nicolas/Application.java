package nicolas;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolas.dao.PartecipazioneDAO;
import nicolas.dao.EventoDAO;
import nicolas.dao.LocationDAO;
import nicolas.dao.PersoneDAO;
import nicolas.entities.*;

import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersoneDAO personeDAO = new PersoneDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        Random rndm = new Random();

        Persona persona = personeDAO.findById(1);
        Evento event = eventoDAO.findById(1);

        Partecipazione partecipazione = new Partecipazione(persona, event);

        persona.getListaPartecipazioni().forEach(System.out::println);

        eventoDAO.findByIdAndDelete(24);


        em.close();
        emf.close();
    }
}
