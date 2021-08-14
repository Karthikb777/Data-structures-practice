#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node * next;
};

void traversal(struct Node * top) {
    struct Node * ptr = top;
    while(ptr != NULL) {
        printf("element: %d\n", ptr->data);
        ptr = ptr->next;
    }
}

struct Node * push(struct Node * top, int element) {
    struct Node * newNode  = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = element;

    newNode->next = top;
    top = newNode;

    return top;
}

// i'm recieving the pointer of the pointer to change the value of the pointer
int pop(struct Node ** top) {
    struct Node * ptr = *top;
    int element = ptr->data;
    *top = (*top)->next;
    free(ptr);
    return element;
}

int peek(struct Node * top, int pos) {
    struct Node * ptr = top;
    for (int i = 0; (i < pos && ptr != NULL); i++) {
        ptr = ptr->next;
    }

    if(ptr != NULL) {
        return ptr->data;
    }
    return -1;
}

int isEmpty(struct Node * top) {
    if(top == NULL) {
        printf("stack is empty\n");
        return 1;
    }
    return 0;
}

int isFull(struct Node * top) {
    struct Node * test = (struct Node *) malloc(sizeof(struct Node));
    if(test == NULL) {
        printf("stack is full\n");
        return 1;
    } 
    return 0;
}

int stackTop(struct Node * top) {
    return top->data;
}

int stackBottom(struct Node * top) {
    struct Node * ptr = top;
    while (ptr->next != NULL)
    {
        ptr = ptr->next;
    }

    return ptr->data;
}

int main() {
    // this is a pointer
    struct Node * top = NULL;
    // isEmpty(top);
    top = push(top, 4);
    top = push(top, 5);
    top = push(top, 6);
    top = push(top, 7);
    top = push(top, 10);
    top = push(top, 232);
    top = push(top, 3445);
    top = push(top, 930);


    for (int i = 0; i < 8; i++) {
        printf("the element at %d is %d\n", i, peek(top, i));
    }
    
    isEmpty(top);
    traversal(top);

    printf("stack top: %d\n", stackTop(top));
    printf("stack bottom: %d\n", stackBottom(top));

    printf("popped element is %d\n", pop(&top)); // i'm sending the address of the pointer
    printf("popped element is %d\n", pop(&top));
    printf("popped element is %d\n", pop(&top));
    traversal(top);
}