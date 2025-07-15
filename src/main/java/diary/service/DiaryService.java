package diary.service;

import diary.dao.DiaryEntryDAO;
import diary.entity.DiaryEntry;

import java.time.LocalDate;
import java.util.List;

public class DiaryService {

    private final DiaryEntryDAO dao;

    public DiaryService(DiaryEntryDAO dao) {
        this.dao = dao;
    }

    public void createEntry(String title, String content, String mood, String tags) {
        DiaryEntry entry = new DiaryEntry();
        entry.setTitle(title);
        entry.setContent(content);
        entry.setMood(mood);
        entry.setTags(tags);
        entry.setEntryDate(LocalDate.now());
        dao.addEntry(entry);
    }

    public List<DiaryEntry> getAllEntries() {
        return dao.getAllEntries();
    }

    public List<DiaryEntry> searchByDate(LocalDate date) {
        return dao.searchByDate(date);
    }

    public List<DiaryEntry> searchByMood(String mood) {
        return dao.searchByMood(mood);
    }

    public List<DiaryEntry> searchByKeyword(String keyword) {
        return dao.searchByKeyword(keyword);
    }

    public DiaryEntry getById(int id) {
        return dao.getById(id);
    }

    public void updateEntry(DiaryEntry entry) {
        dao.updateEntry(entry);
    }

    public void deleteEntry(int id) {
        dao.deleteEntry(id);
    }
}
