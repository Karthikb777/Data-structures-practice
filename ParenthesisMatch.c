#include<stdio.h>
#include<stdlib.h>

struct stack {
    int top;
    char * arr;
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

int push(char element, struct stack * s) {
    if(!isFull(s)) {
        s->top++;
        s->arr[s->top] = element;
        return 1;
    }
    printf("stack overflow!\n");
    return 0;
}

char pop(struct stack * s) {
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

char peek(struct stack * s, int pos) {
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

char stackTop(struct stack * s) {
    return s->arr[s->top];
}

char stackBottom(struct stack * s) {
    return s->arr[0];
}

int matches(char a, char b) {
    if(a == '(' && b == ')') {
        return 1;
    }
    if(a == '[' && b == ']') {
        return 1;
    }
    if(a == '{' && b == '}') {
        return 1;
    }
    return 0;
}

int ParenthesisMatch(char * exp) {
    struct stack * s = (struct stack *) malloc(sizeof(struct stack));
    s->size = 100;
    s->top = -1;
    s->arr = (char *) malloc(s->size * sizeof(char));
    char popped;

    for (int i = 0; exp[i] != '\0'; i++)
    {
        // printf("%s", exp[i]);
       if (exp[i] == '(' || exp[i] == '[' || exp[i] == '{') {
           push(exp[i], s);
       }
       else if (exp[i] == ')' || exp[i] == ']' || exp[i] == '}') {
           if (isEmpty(s)) {
               return 0;
           }
           else {
               popped = pop(s);
           }
           
        if(!matches(popped, exp[i])) {
            return 0;
        }
       }  
    } 

    if (isEmpty(s)) {
        return 0;
    }
    else {
        return 1;
    }
}



int main() {
    char * exp = "[";
    if (ParenthesisMatch(exp))
    {
        printf("the paranthesis is matching\n");
    }
    else {
        printf("the paranthesis is not matching\n");
    }
    
    return 0;
}