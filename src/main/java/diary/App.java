package diary;


import diary.dao.DiaryEntryDAO;
import diary.entity.DiaryEntry;
import diary.service.DiaryService;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DiaryPU");
        EntityManager em = emf.createEntityManager();
        DiaryService service = new DiaryService(new DiaryEntryDAO(em));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Digital Diary Menu ====");
            System.out.println("1. Add Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. Search by Date");
            System.out.println("4. Search by Mood");
            System.out.println("5. Search by Keyword");
            System.out.println("6. Update Entry");
            System.out.println("7. Delete Entry");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 : {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Content: ");
                    String content = sc.nextLine();
                    System.out.print("Mood: ");
                    String mood = sc.nextLine();
                    System.out.print("Tags: ");
                    String tags = sc.nextLine();
                    service.createEntry(title, content, mood, tags);
                    System.out.println("Entry added!");
                    break;
                }
                case 2: {
                    List<DiaryEntry> entries = service.getAllEntries();
                    entries.forEach(App::printEntry);
                    break;
                }
                case 3 : {
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    List<DiaryEntry> byDate = service.searchByDate(date);
                    byDate.forEach(App::printEntry);
                    break;
                }
                case 4 :{
                    System.out.print("Enter mood: ");
                    String mood = sc.nextLine();
                    List<DiaryEntry> byMood = service.searchByMood(mood);
                    byMood.forEach(App::printEntry);
                    break;
                }
                case 5: {
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    List<DiaryEntry> byKeyword = service.searchByKeyword(keyword);
                    byKeyword.forEach(App::printEntry);
                    break;
                }
                case 6: {
                    System.out.print("Enter ID to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    DiaryEntry entry = service.getById(id);
                    if (entry != null) {
                        System.out.print("New Title (" + entry.getTitle() + "): ");
                        entry.setTitle(sc.nextLine());
                        System.out.print("New Content: ");
                        entry.setContent(sc.nextLine());
                        System.out.print("New Mood: ");
                        entry.setMood(sc.nextLine());
                        System.out.print("New Tags: ");
                        entry.setTags(sc.nextLine());
                      service.updateEntry(entry);
                        System.out.println("Entry updated.");
                    } else {
                        System.out.println(" Entry not found.");
                    }
                    break;
                }
                case 7:{
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    service.deleteEntry(id);
                    System.out.println("Entry deleted.");
                    break;
                }
                case 0 : System.out.println(" Exiting...");break;
                default: System.out.println(" Invalid choice."); break;
            }

        } while (choice != 0);

        em.close();
        emf.close();
        sc.close();
    }

    private static void printEntry(DiaryEntry e) {
        System.out.println("\n ID: " + e.getId());
        System.out.println(" Date: " + e.getEntryDate());
        System.out.println(" Title: " + e.getTitle());
        System.out.println(" Content: " + e.getContent());
        System.out.println(" Mood: " + e.getMood());
        System.out.println(" Tags: " + e.getTags());
    }
}

