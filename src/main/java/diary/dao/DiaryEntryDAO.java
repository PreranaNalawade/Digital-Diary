package diary.dao;

import diary.entity.DiaryEntry;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class DiaryEntryDAO {

    private final EntityManager em;

    public DiaryEntryDAO(EntityManager em) {
        this.em = em;
    }

    public void addEntry(DiaryEntry entry) {
        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();
    }

    public DiaryEntry getById(int id) {
        return em.find(DiaryEntry.class, id);
    }

    public List<DiaryEntry> getAllEntries() {
        return em.createQuery("SELECT e FROM DiaryEntry e ORDER BY e.entryDate DESC", DiaryEntry.class)
                 .getResultList();
    }

    public List<DiaryEntry> searchByDate(LocalDate date) {
        return em.createQuery("SELECT e FROM DiaryEntry e WHERE e.entryDate = :date", DiaryEntry.class)
                 .setParameter("date", date)
                 .getResultList();
    }

    public List<DiaryEntry> searchByMood(String mood) {
        return em.createQuery("SELECT e FROM DiaryEntry e WHERE LOWER(e.mood) = LOWER(:mood)", DiaryEntry.class)
                 .setParameter("mood", mood)
                 .getResultList();
    }

    public List<DiaryEntry> searchByKeyword(String keyword) {
        return em.createQuery("SELECT e FROM DiaryEntry e WHERE LOWER(e.title) LIKE :keyword OR LOWER(e.content) LIKE :keyword", DiaryEntry.class)
                 .setParameter("keyword", "%" + keyword.toLowerCase() + "%")
                 .getResultList();
    }

    public void updateEntry(DiaryEntry entry) {
        em.getTransaction().begin();
        em.merge(entry);
        em.getTransaction().commit();
    }

    public void deleteEntry(int id) {
        DiaryEntry entry = em.find(DiaryEntry.class, id);
        if (entry != null) {
            em.getTransaction().begin();
            em.remove(entry);
            em.getTransaction().commit();
        }
    }
}
