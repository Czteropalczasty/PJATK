package zad3;

public class Podpowiedź {

}
// Podpowiedź : Tutaj trzeba użyć specjalnie zdefiniowanego interfacu który potrafi wyrzucić exception, po tym jest dokładnie takie same jak zad 2
//Np :
interface ExampleInterface {
    int doSomething();
}
interface ExampleInterfaceThatThrowException extends ExampleInterface{
    int doSomethingThatThrowsException() throws Exception;

    @Override
    default int doSomething() {
        try{
            return doSomethingThatThrowsException();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}