import java.io.*;
import java.nio.file.*;

public class FileManager {
    private static final String FILE_PATH = "save_data.txt";
    private static final String BACKUP_PATH = "save_data_backup.txt";

    public static void simpanData() {
        try {
            Path filePath = Paths.get(FILE_PATH).toAbsolutePath();
            Path parentDir = filePath.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            if (Files.exists(filePath)) {
                Files.copy(filePath, Paths.get(BACKUP_PATH), StandardCopyOption.REPLACE_EXISTING);
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile()))) {
                writer.println(GlobalData.poin);
                for (String artefak : GlobalData.artefakDibeli) {
                    writer.println("A:" + artefak);
                }
                for (String level : GlobalData.levelTerselesaikan) {
                    writer.println("L:" + level);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public static void muatData() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        GlobalData.poin = Integer.parseInt(reader.readLine());
        String line;
        GlobalData.artefakDibeli.clear();
        GlobalData.levelTerselesaikan.clear();

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("A:")) {
                GlobalData.artefakDibeli.add(line.substring(2));
            } else if (line.startsWith("L:")) {
                GlobalData.levelTerselesaikan.add(line.substring(2));
            }
        }
    } catch (IOException e) {
        System.out.println("Data belum ada, dimulai baru.");
        GlobalData.poin = 0;
        GlobalData.artefakDibeli.clear();
        GlobalData.levelTerselesaikan.clear();
    }
}

}

    