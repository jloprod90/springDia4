package org.example;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Observable<String> messageSender = Observable.just("Mensaje1","Mensaje2","Mensaje3");

        messageSender.subscribe(new Observer() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("Observer1. Subscribed.");

            }

            public void onNext(Object t) {
                System.out.println("Observer1. Recibed" + t);

            }

            public void onError(Throwable throwable) {
                System.out.println("Observer. Error: " + throwable.getMessage() );
            }

            public void onComplete() {
                System.out.println("Observer1. Completed");
            }
        });

        System.out.println("______________________________");

        messageSender.subscribe(new Observer() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("Observer2. Subscribed.");

            }

            public void onNext(Object t) {
                System.out.println("Observer2. Recibed" + t);

            }

            public void onError(Throwable throwable) {
                System.out.println("Observer. Error: " + throwable.getMessage() );
            }

            public void onComplete() {
                System.out.println("Observer2. Completed");
            }
        });
    }
}
