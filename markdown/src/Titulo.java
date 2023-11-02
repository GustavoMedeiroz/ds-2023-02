public class Titulo implements Markdown {
    private Markdown componente;

    public Titulo(Markdown componente) {
        this.componente = componente;
    }

    @Override
    public void exibe() {
        System.out.print("# ");
        componente.exibe();
    }
}