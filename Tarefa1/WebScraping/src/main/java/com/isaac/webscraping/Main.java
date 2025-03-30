package com.isaac.webscraping;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        Compactador compactador = new Compactador();
        scraper.baixarArquivos();
        compactador.compactarArquivos();
    }
}
