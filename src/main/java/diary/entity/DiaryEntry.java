package diary.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diary_entries")
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length = 2000)
    private String content;

    private LocalDate entryDate;

    private String mood;

    private String tags;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }
}
