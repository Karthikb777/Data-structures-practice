#include<stdio.h>

// void append(int element, int arr[]) {
//     int size = sizeof(arr) / sizeof(int);
    
// }

int traversal(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    
}

int insert(int element, int index, int arr[], int size) {
    for(int i = size - 1; i >= index; i--) {
        arr[i + 1] = arr[i];
    }
    arr[index] = element;
    // traversal(arr, size + 1);
    return 1;
}

int delete(int index, int arr[], int size) {
    for (int i = index; i < size - 1; i++) {
        arr[i] = arr[i + 1];
    }
    return 1;
}

int linearSearch(int searchItem, int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        if(arr[i] == searchItem) {
            return i;
        }
    }
    return -1;   
}

int binarySearch(int searchItem, int arr[], int size) {
    int low, mid, high;
    low = 0;
    high = size-1;
    while(low<=high) {
         mid = ( low + high ) / 2;
        if(arr[mid] == searchItem) {
            return mid;
        }
        if(arr[mid] < searchItem) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }
    return -1;
}


int main() {
    int arr[100] = {1, 3, 5, 7, 9};
    int size = 5;
    traversal(arr, size);
    insert(25, 2, arr, size);
    size += 1;
    printf("after insertion \n");
    traversal(arr, size);
    delete(3, arr, size);
    size -= 1;
    printf("after deletion \n");
    traversal(arr, size);
    int elem = 3;
    int res = binarySearch(elem, arr, size);
    printf("%d was found at %d\n", elem, res);
}