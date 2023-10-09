package Formatacao

class PadraoTissFormat {

    String name
    String versao
    String link

    PadraoTissFormat(String name, String versao, String link) {
        this.name = name
        this.versao = versao
        this.link = link
    }

    @Override
    String toString() {
        return "name='" + name + '\'' +
                ", versao='" + versao + '\'' +
                ", link='" + link + "'";
    }

}