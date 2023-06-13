public class Main {
    public static void main(String[] args) {
        int[] arr = {123, 44, 71, 2, 1, -33, 0, 567, 46, 99, 90, 34, -12, 234};

        heapSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void heapSort(int[] arr) {
        //длина массива
        int n = arr.length;

        //создаём дерево, построение кучи (перегруппируем массив)
        for(int i  = n / 2 - 1; i >= 0; i--)
            heapify(arr, i , n);

        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--){

            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int n) {
        //левый ребёнок
        int l = i * 2 + 1;

        //правый ребёнок
        int r = i * 2 + 2;

        //Инициализируем наибольший элемент как корень
        int largest = i;

        //Если левый дочерний элемент больше корня
        if(l < n && arr[l] > arr[largest])
            largest = l;

        //Если правый дочерний элемент больше,
        // чем самый большой элемент на данный момент
        if(r < n && arr[r] > arr[largest])
            largest = r;

        //Если, ребёнок оказался больше родителя, то делаем обмен,
        //ребёнка с родителем. Если самый большой элемент не корень
        if (i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, largest, n);
        }
    }
}
