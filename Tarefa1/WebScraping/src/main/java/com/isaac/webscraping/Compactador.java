package com.isaac.webscraping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {
    public void compactarArquivos() {
        File dir = new File("ResultadoFinal");
        if (!dir.exists()) dir.mkdirs();

        String[] pathPdfs = {"ArquivosBaixados/Anexo1.pdf", "ArquivosBaixados/Anexo2.pdf"};
        String pathArquivoCompactado = "ResultadoFinal/ArquivosZipados.zip";

        System.out.println("\nIniciando compactação...");

        try (FileOutputStream fileOutputStream = new FileOutputStream(pathArquivoCompactado);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            for (String filePath : pathPdfs) {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("Arquivo " + filePath + " não encontrado para compactação.");
                    continue;
                }

                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(entry);

                    byte[] buffer = new byte[2048];
                    int bytesLidos;
                    while ((bytesLidos = fileInputStream.read(buffer)) != -1) {
                        zipOutputStream.write(buffer, 0, bytesLidos);
                    }
                    zipOutputStream.closeEntry();
                }
            }
            System.out.println("\nArquivos compactados com sucesso em " + pathArquivoCompactado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}