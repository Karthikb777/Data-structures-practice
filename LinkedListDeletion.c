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

// deletion of the first node
struct Node * deleteAtFirst(struct Node * head) {
    struct Node * p = head;
    head = head ->next;
    free(p);
    return head;
}

// deletion of the node at a given index
void deleteAtIndex(struct Node * head, int index) {
    struct Node * p = head;
    struct Node * q = head -> next;

    for(int i = 0; i < index - 1; i++) {
        p = p -> next;
        q = q -> next;
    }

    p->next = q->next;
    free(q);
}

// deletion of the last node in the linked list
void deleteAtLast(struct Node * head) {
    struct Node * p = head;
    struct Node * q = head-> next;

    while (q->next != NULL)
    {
        p = p->next;
        q = q->next;
    }

    p->next = NULL;
    free(q);    
}

// deletion of a node with a given value in the linked list
void deleteAtGivenValue(struct Node * head, int value) {
    struct Node * p = head;
    struct Node * q = head -> next;

    while (q->data != value && q -> next != NULL)
    {
        p = p->next;
        q = q->next;
    }

    if (q->data == value) {
        p -> next = q -> next;
        free(q);
    }
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

    printf("before deletion\n");
    head = traverse(head);
    // head = deleteAtFirst(head);
    // deleteAtIndex(head, 2);
    // deleteAtLast(head);
    deleteAtGivenValue(head, 3);
    printf("\nAfter deletion\n");
    head = traverse(head);


    return 0;
}