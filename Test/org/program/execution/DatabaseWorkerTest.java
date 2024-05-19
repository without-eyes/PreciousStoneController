package org.program.preciousstonemanager.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DatabaseWorkerTest {
    private String folderName;

    @BeforeEach
    void setUp() {
        folderName = "collection";
    }

    @Test
    void cleanNecklace() throws IOException {
        String folderPath = "files\\items\\" + folderName;
        File directoryPath = new File(folderPath);
        File[] filesList = directoryPath.listFiles();
        System.gc();
        assert filesList != null;
        for (File file : filesList)
            if (!file.isDirectory())
                file.delete();

        Path dirPath = Paths.get("files\\items\\");
        boolean isEmptyDirectory = Files.list(dirPath).findAny().isPresent();

        Assertions.assertTrue(isEmptyDirectory);
    }
}