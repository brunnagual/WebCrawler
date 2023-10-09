import WebCrawler.*

static void main(String[] args) throws IOException {
    ErrosTiss planilhaErros = new ErrosTiss()
    PadraoTiss arquivosTiss = new PadraoTiss()
    HistoricoTiss tabelaVersoes = new HistoricoTiss()

    Scanner leitor = new Scanner(System.in)
    boolean app = true
    String verificador = ""

    while (app) {
        println()
        println "Digite o número correspondente à ação desejada\n" +
                "1. Baixar Padrão TISS atualizado\n" +
                "2. Listar Histórico das versões dos Componentes do Padrão TISS a partir de JAN/2016\n" +
                "3. Baixar Tabela de erros no envio para a ANS\n" +
                "4. Encerrar a aplicação"
        println("Digite um número de 1 a 4: ")

        verificador = leitor.nextLine()
        String regexVerificador = '^[1234]$'

        if (verificador.matches(regexVerificador)) {
            switch (verificador) {
                case "1":
                    println "Para salvar os arquivos, encerre a aplicação"
                    PadraoTiss padraoTiss = new PadraoTiss()
                    padraoTiss.baixaArquivos(padraoTiss.instanciaListaObjetos())
                    break
                case "2":
                    List versoes = tabelaVersoes.instanciaListaHistoricoVersoes()
                    versoes.forEach {versao ->
                        println versao.toString()
                    }
                    break
                case "3":
                    println "Para salvar os arquivos, encerre a aplicação"
                    planilhaErros.baixaPlanilhaErros()
                    break
                case "4":
                    app = false
                    break
            }
        } else {
            println "Digite uma opção válida"
        }
    }

    leitor.close()
}
