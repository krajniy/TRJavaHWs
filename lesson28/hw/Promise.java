package TRJavaHWs.lesson28.hw;

public class Promise<T> {
    private T value;

    //Должны присутствовать методы hasValue(): boolean и getValue(): T

    public boolean hasValue() {
        return value != null;
    }

    public T getValue(){
        return value;
    }

    void setValue(T value){
        this.value = value;
    }
}

@FunctionalInterface
interface Promisable<T>{
    T getPromise();
}

class PromiseRunner{
    public <T> Promise<T> run(Promisable<T> promisable){
        Promise<T> promise = new Promise<>();
        (new Thread(()->{
            T value = promisable.getPromise();
            promise.setValue(value);

        })).start();


        return promise;

    }
}
