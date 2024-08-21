package nicolas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import nicolas.entities.Location;



public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location loc) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(loc);
            t.commit();
            System.out.println("Location - " + loc.getNome() + " - creata!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Location findById(long id) {
        return em.find(Location.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Location found = em.find(Location.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Location eliminata");
            } else System.out.println("Location non trovata");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}