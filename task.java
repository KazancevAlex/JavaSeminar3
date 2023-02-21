// Реализовать алгоритм сортировки слиянием


class task {
        public static void main(String args[]) {
        int arr[] = { 8, 15, 6, 7, 9, 40, 1 };
        System.out.println("Заданный массив: ");
        printArray(arr);

        task mergedArr = new task();
        mergedArr.sort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив: ");
        printArray(arr);
    }
    void merge(int arr[], int left, int mid, int right) {
        // вычисляем размеры подмассивов, которые нужно объединить
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // создаем разделенные массивы
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        // заносим данные в разделенные массивы 
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[mid + 1 + j];

        // объединяем разделенные массивы:        
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        // копируем оставшиеся элементы левого подмассива
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        // копируем оставшиеся элементы правого подмассива
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int left, int right) {
        if (left < right) {
            // нахождение середины
            int mid = (left + right) / 2;

            // сортировка первой и второй половины
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // объединение отсортированных половин обратно
            merge(arr, left, mid, right);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
