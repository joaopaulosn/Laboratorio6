import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  
  public static void main(String[] args) {
    if(args.length < 2) {
      throw new RuntimeException("compile o programa informando o tamanho do vetor e a quantidade de threads respectivamente");
    }
    
    Integer tamVetor = Integer.parseInt(args[0]);
    Integer qtdThreads = Integer.parseInt(args[1]);
    Thread[] threads = new Thread[qtdThreads];
    List<Integer> Aleatoria = new ArrayList<Integer>();
    Random gerador = new Random();

    for(int i = 0; i < tamVetor; i++) {
      Aleatoria.add(gerador.nextInt(500)); 
    }

    Lista lista = new Lista(Aleatoria);
    int quociente = tamVetor / qtdThreads;
    int resto = tamVetor % qtdThreads;
    

    for(int i = 0; i < qtdThreads; i++) {
      int inicio = i*quociente;
      int fim = (i+1)*quociente;
      if(i == qtdThreads - 1) fim += resto;
      threads[i] = new Executor(i, inicio, fim, lista);
    }


    
    for(int i = 0; i < qtdThreads; i++) {
      threads[i].start();
    }

    
    for(int i = 0; i < qtdThreads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
    
    System.out.println(String.format("%d pares.", lista.getContador()));
  }
}