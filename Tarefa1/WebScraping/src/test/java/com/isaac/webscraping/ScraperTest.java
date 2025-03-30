package com.isaac.webscraping;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScraperTest {

    @Test
    void testDownloadArquivos() {
        Scraper scraper = new Scraper();
        scraper.baixarArquivos();

        File arquivo1 = new File("ArquivosBaixados/Anexo1.pdf");
        File arquivo2 = new File("ArquivosBaixados/Anexo2.pdf");

        assertTrue(arquivo1.exists(), "O arquivo Anexo1.pdf deveria existir.");
        assertTrue(arquivo2.exists(), "O arquivo Anexo2.pdf deveria existir.");
    }
}