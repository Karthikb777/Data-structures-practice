#include<stdio.h>
#include<stdlib.h>

struct stack {
    int top;
    int * arr;
    int size;
};

int isEmpty(struct stack * s) {
    if (s->top == -1)
    {
        return 1;
    }
return 0;
}

int isFull(struct stack * s) {
    if(s->top == s->size-1) {
        return 1;
    }
    return 0;
}

int push(int element, struct stack * s) {
    if(!isFull(s)) {
        s->top++;
        s->arr[s->top] = element;
        return 1;
    }
    printf("stack overflow!\n");
    return 0;
}

int pop(struct stack * s) {
    int element;
    if (!isEmpty(s))
    {
        element = s->arr[s->top];
        s->top--;
        return element; 
    }
    printf("stack underflow!\n");
    return -1;
}

int peek(struct stack * s, int pos) {
    int position = s->top - pos + 1;
    if (position < 0)
    {
        printf("invalid position\n");
        return -1;
    }
    else {
        return s->arr[position];
    } 
}

int stackTop(struct stack * s) {
    return s->arr[s->top];
}

int stackBottom(struct stack * s) {
    return s->arr[0];
}

int main() {
    struct stack * s = (struct stack *) malloc(sizeof(struct stack));
    s->size = 10;
    s->top = -1;
    s->arr = (int *) malloc(s->size * sizeof(int));

   

    push(10,s);
    push(20,s);
    push(30,s);
    push(40,s);
    push(50,s);
    push(60,s);
    push(70,s);
    push(80,s);
    push(90,s);
    push(100,s);
    // push(100,s);
    
   for (int i = 1; i < s->size + 1; i++)
   {
    printf("element at position %d is %d\n", i, peek(s, i));
   }
   
    printf("stack top is %d\n", stackTop(s));
    printf("stack bottom is %d\n", stackBottom(s));
    // printf("%d\n", pop(s));
    // printf("%d\n", pop(s));
    if (isFull(s))
    {
        printf("stack is full\n");
    }
    
    return 0;
}