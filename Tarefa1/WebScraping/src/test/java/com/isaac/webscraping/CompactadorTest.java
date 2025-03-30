package com.isaac.webscraping;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompactadorTest {

    @Test
    void testCompactacaoArquivos() {
        Compactador compactador = new Compactador();
        compactador.compactarArquivos();

        File zipFile = new File("ResultadoFinal/ArquivosZipados.zip");
        assertTrue(zipFile.exists(), "O arquivo ZIP deveria ser criado.");
    }
}