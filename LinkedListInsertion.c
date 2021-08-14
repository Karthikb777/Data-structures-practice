#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node * next;
};

struct Node * traverse(struct Node * head) {
    struct Node * p;
    p = head;

    while (p != NULL)
    {
        printf("%d\n", p->data);
        p = p->next;
    }
    return head;
}

// insertion operations
// insert at the beginning
struct Node * insertAtBeginning(struct Node * head, int data) {
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = head;
    head = newNode;
    return head;
};

// insertion at the middle
void insertAtMiddle(struct Node * head, int index, int data) {
    struct Node * p = head;
    int i = 0;
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = data;

    while (i != index-1)
    {
        p = p ->next;
        i++;
    }

    newNode->next = p->next;
    p->next = newNode;
}

// insertion at the end
void insertAtEnd(struct Node * head, int data) {
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = data;

    struct Node * p = head;
    while (p->next != NULL) {
        p = p->next;
    }
    newNode->next = NULL;
    p->next = newNode;
}

// insert after a node
void insertAfterNode(struct Node * prevNode, int data) {
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = data;

    struct Node * p;
    p = prevNode->next;

    newNode->next = p;
    prevNode->next = newNode;
}


int main() {
    struct Node * head;
    struct Node * first = (struct Node *) malloc(sizeof(struct Node));
    struct Node * second = (struct Node *) malloc(sizeof(struct Node));
    struct Node * third = (struct Node *) malloc(sizeof(struct Node));
    struct Node * fourth = (struct Node *) malloc(sizeof(struct Node));
    head = first;

    first->data = 1;
    first->next = second;

    second->data = 3;
    second->next = third;
    
    third->data = 5;
    third->next = fourth;
    
    fourth->data = 7;
    fourth->next = NULL;

    printf("before insertion\n");
    head = traverse(head);
    // head = insertAtBeginning(head, 25);
    // insertAtMiddle(head, 3, 100);
    // insertAtEnd(head, 101);
    insertAfterNode(first, 102);
    printf("\nAfter insertion\n");
    head = traverse(head);


    return 0;
}