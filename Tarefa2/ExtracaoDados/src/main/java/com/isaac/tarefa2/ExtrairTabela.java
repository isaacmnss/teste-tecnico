package com.isaac.tarefa2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;

import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

public class ExtrairTabela {
    public static List<Table> extrairTabelaDoArquivo() throws IOException {
        File file = new File("Arquivopdf/AnexoI.pdf");
        PDDocument document = Loader.loadPDF(file);
        ObjectExtractor extractor = new ObjectExtractor(document);

        List<Table> allTables = new java.util.ArrayList<>();

        for (int pageNumber = 1; pageNumber <= document.getNumberOfPages(); pageNumber++) {
            Page page = extractor.extract(pageNumber);

            // Testa os dois algoritmos de extração
            SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();


            List<Table> tablesSpreadsheet = sea.extract(page);

            // Escolhe a melhor extração (a que contém mais colunas)
            List<Table> selectedTables = tablesSpreadsheet;

            allTables.addAll(selectedTables);

            System.out.println("Página " + pageNumber + ": " + selectedTables.size() + " tabelas extraídas.");
        }

        document.close();
        return allTables;
    }
}