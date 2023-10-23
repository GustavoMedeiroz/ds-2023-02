public class EnumExemplo {
    public static void main(String[] args) {
        // Dias da semana
        System.out.println("Dias da semana:");
        for (DiaDaSemana dia : DiaDaSemana.values()) {
            System.out.println(dia);
        }

        // Permissões em um diretório
        System.out.println("\nPermissões em um diretório:");
        for (Permissao permissao : Permissao.values()) {
            System.out.println(permissao);
        }

        // Tamanho de pizza
        System.out.println("\nTamanho de pizza:");
        for (TamanhoPizza tamanho : TamanhoPizza.values()) {
            System.out.println(tamanho);
        }

        // Pontos cardeais
        System.out.println("\nPontos cardeais:");
        for (PontoCardeal ponto : PontoCardeal.values()) {
            System.out.println(ponto);
        }

        // Posições em um tabuleiro de xadrez
        System.out.println("\nPosições em um tabuleiro de xadrez:");
        for (PosicaoXadrez posicao : PosicaoXadrez.values()) {
            System.out.println(posicao);
        }
    }
}
