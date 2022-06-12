package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
        char aux;
        
        for (int i = 0; i < str.length(); i++) {
            aux = str.charAt(i);
            
            //El stack colecciona signos de puntuacion abiertos (SPA)
            if('('==aux || '['==aux || '{' == aux){
                //El stack colecciona los SPA
                stack.push(aux);
            }
            //Colecciona operadores + o - solo si existe un SPA en el stack 
            if(!stack.isEmpty() && (aux == '+' || aux == '-' )){
                stack.push(aux);
            }
            //Si es que se encuentra un signo puntuacion cerrado (SPC):    ]}) 
            if(')'==aux || ']'==aux || '}' == aux){
                //Si no existe al menos un operador y se tiene un SPA inmediatamente, se considera innecesario
                if('(' == stack.top() || '[' == stack.top() || '{' == stack.top())
                    return true;
                //Si existe al menos un operador en el tope del stack se eliminan hasta llegar a un SPA
                while(stack.top() == '+' || stack.top() == '-'){
                    stack.pop();
                }
                
                //El SPA se cierra, eliminando del stack
                stack.pop();
            }    
        }
        //Si no hay innecesarios se retorna false
        return false;
    }
}
