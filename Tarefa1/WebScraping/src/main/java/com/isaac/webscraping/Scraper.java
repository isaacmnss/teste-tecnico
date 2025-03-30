package com.isaac.webscraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Scraper {
    public void baixarArquivos() {
        final String link = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
        File dir = new File("ArquivosBaixados");
        if (!dir.exists()) dir.mkdirs();
        try{
            System.out.println("\nIniciando download do Arquivo 1...");
           final  Document document = Jsoup.connect(link).get();
           Elements pdfAnexo1= document.select("a[href='https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf']");

           if (pdfAnexo1.isEmpty()){
               System.out.println("\nArquivo não encontrado");
               return;
           }

           String pdfURL = pdfAnexo1.attr("href");

           URL url = new URL(pdfURL);
           InputStream in = url.openStream();
           OutputStream out = new BufferedOutputStream(new FileOutputStream("ArquivosBaixados\\Anexo1.pdf"));

            for (int i; (i = in.read()) != -1;) {
                out.write(i);
            }
            System.out.println("\nArquivo 1 baixado com sucesso.");

            System.out.println("\nIniciando download do arquivo 2...");

            if (pdfAnexo1.isEmpty()){
                System.out.println("Arquivo não encontrado");
                return;
            }

            Elements pdfAnexo2 = document.select("a[href='https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf']");

            if (pdfAnexo2.isEmpty()){
                System.out.println("\nArquivo não encontrado");
                return;
            }

            String pdfURL1 = pdfAnexo2.attr("href");
            URL url1 = new URL(pdfURL1);
            in = url1.openStream();
            out = new BufferedOutputStream(new FileOutputStream("ArquivosBaixados\\Anexo2.pdf"));

            for (int j; (j = in.read()) != -1;) {
                out.write(j);
            }

            System.out.println("\nArquivo 2 Baixado com sucesso");

            in.close();
            out.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
