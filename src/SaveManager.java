import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveManager {
    private static final String FILE_NAME = "savegame.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveGame(Hero hero) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(hero, writer);
            System.out.println("Game saved successfully to " + FILE_NAME + "!");
        } catch (IOException e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }
    public static Hero loadGame() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Hero hero = gson.fromJson(reader, Hero.class);
            System.out.println("Save file loaded successfully!");
            return hero;
        } catch (IOException e) {
            System.out.println("No save file found or failed to load. Starting a new game.");
            return null;
        }
    }
}


