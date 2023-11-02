public class Item implements Markdown {
    private Markdown componente;

    public Item(Markdown componente) {
        this.componente = componente;
    }

    @Override
    public void exibe() {
        System.out.print(" - ");
        componente.exibe();
    }
}