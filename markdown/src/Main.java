public class Main {
    public static void main(String[] args) {
        // Construção da sentença em Markdown
        Markdown titulo = new Titulo(new Texto("Título"));
        Markdown linha = new Texto("Uma simples linha, com ");
        Markdown negrito = new Negrito(new Texto("negrito"));
        Markdown italico = new Italico(new Texto("itálico"));
        Markdown item = new Item(new Italico(new Texto("Primeiro item da linha com itálico.")));

        Markdown sentenca = new Concatena(titulo, new Concatena(new Texto("\n"), new Concatena(linha, new Concatena(new Texto(" e "), new Concatena(negrito, new Concatena(new Texto(" e "), new Concatena(italico, new Concatena(new Texto("."), new Concatena(new Texto("\n"), item)))))))));

        // Exibe a sentença em Markdown
        sentenca.exibe();
    }
}