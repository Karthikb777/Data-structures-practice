#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node * next;
};

void traversal(struct Node * head) {
    struct Node * ptr = head;
    do {
        printf("%d\n", ptr->data);
        ptr = ptr -> next;
    } while(ptr != head);
}

struct Node * insertAtFirst(struct Node * head, int value) {
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = value;

    struct Node * p = head->next;

    do {
        p = p->next;
    }while(p->next != head);

    p->next = newNode;
    newNode->next = head;
    head = newNode;
    return head;
}

void insertAtIndex(struct Node * head, int index, int value) {
    struct Node * newNode = (struct Node *) malloc(sizeof(struct Node));
    newNode->data = value;

    struct Node * p = head;

    for (int i = 0; i < index - 1; i++)
    {
        p = p->next;
    }

    newNode->next = p->next;
    p->next = newNode;
}

struct Node * deleteAtFirst(struct Node * head) {
    struct Node * p = head;
    struct Node * q = head -> next;

    while (p->next != head)
    {
        p = p->next;
        q = q->next;
    }

    p->next = q->next;

    free(q);
    head = p->next;
    return head;
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
    fourth->next = head;
    printf("before deletion\n");
    traversal(head);
    // head = insertAtFirst(head, 100);
    // insertAtIndex(head, 2, 100);
    head = deleteAtFirst(head);
    head = deleteAtFirst(head);
    printf("\nafter deletion\n");
    traversal(head);
}