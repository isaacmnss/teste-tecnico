package com.isaac.tarefa2;

import java.io.*;

public class AlterarAbreviacoes {
    public static void substituir() throws IOException {
        String tempFile = "temp.csv";
        String csvFilePath = "ArquivoCSV/temp.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
             FileWriter writer = new FileWriter(tempFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\bOD\\b", "Segmentação Odontológica");
                line = line.replaceAll("\\bAMB\\b", "Segmentação Ambulatorial");
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Substituir o arquivo original pelo modificado
        new File(csvFilePath).delete();
        new File(tempFile).renameTo(new File(csvFilePath));
    }
}
