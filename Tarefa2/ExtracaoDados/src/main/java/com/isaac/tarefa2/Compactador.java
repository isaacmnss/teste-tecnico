package com.isaac.tarefa2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {
    public static void ziparArquivo() throws IOException {
        File dir = new File("ResultadoFinal");
        if (!dir.exists()) dir.mkdirs();
        String pathCsv = "ArquivoCSV/temp.csv";
        String pathArquivoZipado = "ResultadoFinal/Teste_{Isaac}.zip";

        try (FileOutputStream fos = new FileOutputStream(pathArquivoZipado);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(pathCsv)) {

            ZipEntry zipEntry = new ZipEntry(new File(pathCsv).getName());
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
