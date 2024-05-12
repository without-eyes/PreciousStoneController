package program.execution;

import org.apache.log4j.Logger;
import program.stones.PreciousStone;
import program.stones.SemiPreciousStone;
import program.stones.Stone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWorker {
    private static final Logger logger = Logger.getLogger(FileWorker.class);
    private final static String path = "files\\items\\";

    /**
     * @param stone
     * @param folderName
     * @throws IOException
     */
    public static void writeIntoFile(Stone stone, String folderName) throws IOException {
        logger.info("Запис каменя \"" + stone.getName() + "\" у папку \"" + folderName + "\"");

        String fileName = path + folderName + '\\' + stone.getName() + ".txt";
        File file = new File(fileName);
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(stone.getAsString());
        fileWriter.close();
    }

    /**
     * @param folderName
     * @return
     * @throws FileNotFoundException
     */
    public static List<Stone> readFromFile(String folderName) throws FileNotFoundException {
        logger.info("Зчитування каменів з папки \"" + folderName + "\"");
        File directoryPath = new File(path + folderName);
        File[] filesList = directoryPath.listFiles();

        List<Stone> storage = new ArrayList<>();

        Scanner fileReader;
        assert filesList != null;
        for (File file : filesList) {
            fileReader = new Scanner(file);
            String stoneInfo = fileReader.nextLine();
            String[] stoneInfoArray = stoneInfo.split(" ");

            String name = stoneInfoArray[0];
            String type = stoneInfoArray[2].substring(0, stoneInfoArray[2].length() - 1);
            String color = stoneInfoArray[4].substring(0, stoneInfoArray[4].length() - 1);
            int weight = Integer.parseInt(stoneInfoArray[6].substring(0, stoneInfoArray[6].length() - 1));
            int value = Integer.parseInt(stoneInfoArray[8].substring(0, stoneInfoArray[8].length() - 1));
            int transparency = Integer.parseInt(stoneInfoArray[11].substring(0, stoneInfoArray[11].length() - 1));

            if (type.equals("дорогоцінний")) {
                storage.add(new PreciousStone(name, color, weight, value, transparency));
            } else if (type.equals("напівкоштовний")) {
                storage.add(new SemiPreciousStone(name, color, weight, value, transparency));
            }
        }

        return storage;
    }

    /**
     * @param stone
     * @param folderName
     */
    public static void deleteFile(Stone stone, String folderName) {
        logger.info("Видалення каменя \"" + stone.getName() + "\" з папки \"" + folderName + "\"");
        String fileName = path + folderName + '\\' + stone.getName() + ".txt";
        File file = new File(fileName);
        System.gc();
        file.delete();
    }

    /**
     * @param folderName
     */
    public static void cleanFolder(String folderName) {
        logger.info("Очищення папки \"" + folderName + "\"");
        String folderPath = path + folderName;
        File directoryPath = new File(folderPath);
        File[] filesList = directoryPath.listFiles();
        System.gc();
        assert filesList != null;
        for (File file : filesList)
            if (!file.isDirectory())
                file.delete();
    }
}
