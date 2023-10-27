import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable {
    private String identificador;
    private List<Consumer<Void>> observers = new ArrayList<>();

    public Observable(String identificador) {
        this.identificador = identificador;
    }

    public void adicionarObserver(String observado, Consumer<Void> observer) {
        if (observado.equals(identificador)) {
            observers.add(observer);
        } else {
            System.out.println("Identificador do Observer não coincide com o identificador do Observable.");
        }
    }

    public void notificarObservers() {
        for (Consumer<Void> observer : observers) {
            observer.accept(null); // Notifica o observador
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crie um objeto Observable com um identificador
        Observable carroObservable = new Observable("carro");

        // Adicione um observador usando uma expressão lambda
        carroObservable.adicionarObserver("carro", observer -> {
            System.out.println("Carro Observer foi notificado.");
            // Adicione aqui a lógica específica para o observador do carro.
        });

        // Notifique os observadores
        carroObservable.notificarObservers();
    }
}
