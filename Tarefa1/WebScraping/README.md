# Documentação da `tarefa1`

## Visão Geral
A `tarefa1` contém a implementação de uma funcionalidade específica relacionada à extração e manipulação de arquivos PDF,
bem como sua compactação em um arquivo ZIP.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

```
/
├── src/com/isaac/webscraping/
│   ├── Scraper.java          # Responsável pelo download dos arquivos PDF
│   ├── Compactador.java      # Responsável pela compactação dos arquivos baixados
│   ├── Main.java             # Classe principal para execução do processo
├── ArquivosBaixados/         # Diretório onde os PDFs são armazenados
├── ResultadoFinal/           # Diretório onde o arquivo ZIP final é salvo
└── README.md                 # Documentação geral do projeto
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

## Como Executar
1. **Clonar o Repositório**
   ```bash
   git clone -b tarefa1 https://github.com/isaacmnss/teste-tecnico.git
   cd teste-tecnico
   ```

2. **Compilar o Projeto**
   ```bash
   javac src/com/isaac/webscraping/*.java -d bin
   ```

3. **Executar a Aplicação**
   ```bash
   java -cp bin com.isaac.webscraping.Main
   ```

## Dependências
- **[Jsoup](https://jsoup.org/)**: Utilizado para fazer a extração dos links dos PDFs a partir do HTML.

