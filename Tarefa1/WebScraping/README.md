# Documentação da tarefa 1

## Visão Geral
A tarefa contém a implementação de uma funcionalidade específica relacionada à extração e manipulação de arquivos PDF,
bem como sua compactação em um arquivo ZIP.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

```
/
├── src/main/java/com/isaac/webscraping/
│   ├── Scraper.java          # Responsável pelo download dos arquivos PDF
│   ├── Compactador.java      # Responsável pela compactação dos arquivos baixados
│   ├── Main.java             # Classe principal para execução do processo
├── src/test/java/com/isaac/webscraping/ # Diretório onde estão armazenados os testes
├── ArquivosBaixados/         # Diretório onde os PDFs são armazenados
├── ResultadoFinal/           # Diretório onde o arquivo ZIP final é salvo
└── README.md                 # Documentação da tarefa
```

## Funcionalidades
A implementação desta branch realiza as seguintes tarefas:

1. **Download de Arquivos PDF**
   - A classe `Scraper.java` acessa um site específico (`https://www.gov.br/ans/pt-br/...`) e faz o download de dois arquivos PDF para a pasta `ArquivosBaixados/`.
   - O conteúdo HTML é analisado utilizando a biblioteca `Jsoup`.
   - Os arquivos são salvos localmente com os nomes `Anexo1.pdf` e `Anexo2.pdf`.

2. **Compactação dos Arquivos**
   - A classe `Compactador.java` lê os arquivos baixados e os adiciona a um arquivo ZIP chamado `ArquivosZipados.zip`, salvo na pasta `ResultadoFinal/`.
   - O processo de compactação é realizado utilizando a biblioteca padrão de `java.util.zip`.

3. **Execução do Processo**
   - A classe `Main.java` coordena a execução, chamando `Scraper` para baixar os arquivos e `Compactador` para compactá-los.

## Testes Automatizados
O projeto inclui testes automatizados utilizando **JUnit 5** para garantir o funcionamento correto das funcionalidades.

### **Descrição dos Testes**

- **ScraperTest.java**: Testa se os arquivos PDF são baixados corretamente e salvos na pasta `ArquivosBaixados/`.

- **CompactadorTest.java**: Testa se os arquivos baixados são corretamente compactados em `ResultadoFinal/ArquivosZipados.zip`.

## Dependências
- **[Jsoup](https://jsoup.org/)**: Utilizado para fazer a extração dos links dos PDFs a partir do HTML.
- **JUnit 5**: Framework para testes unitários.
- **Java 8 ou superior**:


