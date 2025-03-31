package com.isaac.tarefa2;

import java.io.IOException;
import java.util.List;

import technology.tabula.Table;


public class Main {
    public static void main(String[] args) {

        String zipPath = "Teste_seu_nome.zip";

        try {
            System.out.println("Extraindo tabelas do PDF...");
            List<Table> tables = ExtrairTabela.extrairTabelaDoArquivo();

            System.out.println("Salvando tabelas no arquivo CSV...");
            CriarCsv.converterParaCsv(tables);

            System.out.println("Substituindo abreviações...");
            AlterarAbreviacoes.substituir();

            System.out.println("Compactando arquivo CSV em ZIP...");
            Compactador.ziparArquivo();
//
//            System.out.println("Processo concluído com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}