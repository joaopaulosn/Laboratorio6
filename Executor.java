public class Executor extends Thread {
  private Lista lista;
  private int inicio;
  private int end;

  public Executor(int id, int inicio, int end, Lista lista) {
    this.inicio = inicio;
    this.end = end;
    this.lista = lista;
  }

  public void run() {
    for(int i = inicio; i < end; i++) {
      if(lista.getPosition(i) % 2 == 0) {
        lista.increment();
      }
    }
  }
}