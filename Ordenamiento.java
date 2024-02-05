import java.util.Arrays;
import java.util.Random;

public class Ordenamiento {

    // Algoritmo de ordenamiento por selección (ascendente)
    public static void seleccionAscendente(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Algoritmo de ordenamiento por selección (descendente)
    public static void seleccionDescendente(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Algoritmo de ordenamiento por inserción (ascendente)
    public static void insercionAscendente(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Algoritmo de ordenamiento por inserción (descendente)
    public static void insercionDescendente(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Algoritmo de ordenamiento Shell (ascendente)
    public static void shellAscendente(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    // Algoritmo de ordenamiento Shell (descendente)
    public static void shellDescendente(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] < temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    // Algoritmo de ordenamiento rápido (quicksort)
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Método para imprimir un arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Generar arreglo desordenado
        int[] arregloDesordenado = new int[1000];
        Random random = new Random();

        for (int i = 0; i < arregloDesordenado.length; i++) {
            arregloDesordenado[i] = random.nextInt(1000);
        }

        // Copiar el arreglo desordenado para cada método
        int[] arregloSeleccionAscendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloSeleccionDescendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloInsercionAscendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloInsercionDescendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloShellAscendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloShellDescendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloQuicksortAscendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);
        int[] arregloQuicksortDescendente = Arrays.copyOf(arregloDesordenado, arregloDesordenado.length);

        // Imprimir el arreglo desordenado para cada método
        System.out.println("Arreglo Desordenado:");
        imprimirArreglo(arregloDesordenado);
        System.out.println();

        // Medir el tiempo de ejecución y ordenar el arreglo con cada método
        long startTime, endTime, duration;

        // Selección ascendente
        startTime = System.nanoTime();
        seleccionAscendente(arregloSeleccionAscendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Selección Ascendente:");
        imprimirArreglo(arregloSeleccionAscendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Selección descendente
        startTime = System.nanoTime();
        seleccionDescendente(arregloSeleccionDescendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Selección Descendente:");
        imprimirArreglo(arregloSeleccionDescendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Inserción ascendente
        startTime = System.nanoTime();
        insercionAscendente(arregloInsercionAscendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Inserción Ascendente:");
        imprimirArreglo(arregloInsercionAscendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Inserción descendente
        startTime = System.nanoTime();
        insercionDescendente(arregloInsercionDescendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Inserción Descendente:");
        imprimirArreglo(arregloInsercionDescendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Shell ascendente
        startTime = System.nanoTime();
        shellAscendente(arregloShellAscendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Shell Ascendente:");
        imprimirArreglo(arregloShellAscendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Shell descendente
        startTime = System.nanoTime();
        shellDescendente(arregloShellDescendente);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Shell Descendente:");
        imprimirArreglo(arregloShellDescendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Quicksort ascendente
        startTime = System.nanoTime();
        quicksort(arregloQuicksortAscendente, 0, arregloQuicksortAscendente.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Quicksort Ascendente:");
        imprimirArreglo(arregloQuicksortAscendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");

        // Quicksort descendente
        startTime = System.nanoTime();
        quicksort(arregloQuicksortDescendente, 0, arregloQuicksortDescendente.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Quicksort Descendente:");
        imprimirArreglo(arregloQuicksortDescendente);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos\n");
    }
}
