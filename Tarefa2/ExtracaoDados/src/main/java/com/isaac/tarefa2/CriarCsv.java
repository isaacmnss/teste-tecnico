package com.isaac.tarefa2;

import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.util.List;

public class CriarCsv {
    public static void converterParaCsv(List<Table> tables) throws IOException {
        File dir = new File("ResultadoFinal");
        if (!dir.exists()) dir.mkdirs();
        String pathCsv = "ArquivoCSV/temp.csv";

        try (FileWriter writer = new FileWriter(pathCsv)) {
            for (Table table : tables) {
                for (List<RectangularTextContainer> row : table.getRows()) {
                    for (RectangularTextContainer cell : row) {
                        writer.append(cell.getText().replace("\n", " ").replace(",", ";"));
                        writer.append(",");
                    }
                    writer.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
