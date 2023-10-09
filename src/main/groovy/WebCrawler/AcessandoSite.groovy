package WebCrawler

import groovyx.net.http.HttpBuilder
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.helper.HttpConnection
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element



class AcessandoSite {

    static Document carregaPagina() {
        HttpBuilder requestUrlPrincipal = HttpBuilder.configure {
            request.uri = 'https://www.gov.br/ans/pt-br'
        }

        Object responseUrlPrincipal = requestUrlPrincipal.get()

        Document documentUrlPrincipal = Jsoup.parse(responseUrlPrincipal.toString())

        return documentUrlPrincipal
    }

    static Document acessaEspacoPrestadores(){
        Document siteAns = carregaPagina()
        Element botao = siteAns.select("a:contains(Espaço do Prestador de Serviços de Saúde)").first()
        String url = botao.attr("href")
        Connection.Response response = Jsoup.connect(url).execute()
        Document espacoPrestador = response.parse()

        return espacoPrestador
    }

    static Document acessaPaginaTiss(){
        Document espacoPrestador = acessaEspacoPrestadores()
        Element botao = espacoPrestador.select("a:contains(TISS)").first()
        String url = botao.attr("href")
        HttpConnection.Response response = Jsoup.connect(url).execute()
        Document paginaTiss = response.parse()

        return paginaTiss
    }
}

