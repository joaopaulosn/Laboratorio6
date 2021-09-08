import java.util.List;

public class Lista {

  private Integer contador = 0;
  private List<Integer> list;

  public Lista(List<Integer> list) {
    this.list = list;
  }

  public synchronized void increment() {
    this.contador++;
  }

  public Integer getContador() {
    return this.contador;
  }

  public Integer getPosition(int index) {
    return this.list.get(index);
  }
  
}