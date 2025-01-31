
import java.lang.Comparable;

public interface IGenericSort<T extends Comparable<T>>{ //Límito el código, el tipo de dato tiene que poder ser comparable.
    public T[] sort(T[] arr);
}