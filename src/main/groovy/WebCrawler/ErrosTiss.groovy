package WebCrawler

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ErrosTiss {

    AcessandoSite acess = new AcessandoSite()


    Document tabelasRelacionadas(){
        Document paginaTiss = acess.acessaPaginaTiss()
        Element botao = paginaTiss.select("a:contains(planilhas)").first()
        String url = botao.attr("href")
        Connection.Response response = Jsoup.connect(url).execute()
        Document historicoVersoes = response.parse()

        return historicoVersoes
    }

    void baixaPlanilhaErros(){
        Document paginaTiss = tabelasRelacionadas()
        Element botao = paginaTiss.select("a:contains(Clique aqui para baixar a tabela de erros no envio para a ANS (.xlsx))").first()
        String url = botao.attr("href")
        String outputFileName = new URL(url).getFile().tokenize('/').last()
        def destino = new File("./Downloads/Arquivos_padrao_TISS/" + outputFileName)
        destino.parentFile.mkdirs()


        def http = new HTTPBuilder(url)
        http.request(Method.GET) { req ->
            response.success = { resp, reader ->
                destino.withOutputStream { out ->
                    out << reader
                }
            }

            response.failure = { resp ->
                println "Erro ao baixar arquivo: ${resp.statusLine}"
            }
        }
        if (destino.exists()) {
            println("Download da planilha de erros concluído! O arquivo foi salvo em ${destino.absolutePath}.")
        } else {
            println("Erro: a planilha de erros não foi baixada corretamente.")
        }
    }
}
