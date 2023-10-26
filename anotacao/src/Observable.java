import java.util.ArrayList;
import java.util.List;

public class Observable {
    private String identificador;
    private List<Class<?>> observers = new ArrayList<>();

    public Observable(String identificador) {
        this.identificador = identificador;
    }

    public void adicionarObserver(Object observer) {
        Class<?> observerClass = observer.getClass();
        if (observerClass.isAnnotationPresent(Observer.class)) {
            Observer annotation = observerClass.getAnnotation(Observer.class);
            if (annotation.observado().equals(identificador)) {
                observers.add(observerClass);
            } else {
                System.out.println("Identificador do Observer não coincide com o identificador do Observable.");
            }
        } else {
            System.out.println("Classe não é um Observer.");
        }
    }

    public void notificarObservers() {
        for (Class<?> observerClass : observers) {
            // Implemente aqui a lógica de notificação para cada observer.
            // Você pode usar reflection para criar instâncias dos observers e chamar métodos apropriados.
        }
    }
}
