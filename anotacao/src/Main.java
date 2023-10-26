public class Main {
    public static void main(String[] args) {
        // Crie um objeto Observable com um identificador
        Observable carroObservable = new Observable("carro");

        // Crie uma classe que é um Observer com a anotação @Observer
        @Observer(observado = "carro")
        class CarObserver { }

        // Adicione o observer ao Observable
        carroObservable.adicionarObserver(new CarObserver());

        // Notifique os observadores
        carroObservable.notificarObservers();
    }
}
