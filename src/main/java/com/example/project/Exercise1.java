package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        // Colocar codigo aqui
                char aux;
        
        //Se recorre la longitud de la expresion
        for (int i = 0; i < s.length(); i++) {
            //Auxiliar para comparar/guardar
            aux = s.charAt(i);
            
            //Se almacena solo si es Corchete Anidado Abierto (CAA)
            if('('==aux || '['==aux || '{' == aux)
                stack.push(aux);
            
            //Si se lee un ) 
            if(')' == aux){
                //Se verifica que el stack no este vacio, o preceda un CAA diferemnte a (
                if(stack.isEmpty() || stack.top() == '{' || stack.top() == '[')
                    return false;           //Si es asi retorna false;
                stack.pop();
            }
            //Si se lee un ]
            if(']' == aux){
                //Se verifica que el stack no este vacio, o preceda un CAA diferemnte a [
                if(stack.isEmpty() || stack.top() == '{' || stack.top() == '(')
                    return false;
                stack.pop();        //Se hace un pop del stack
            }
            //Si se lee un }
            if('}' == aux){
                //Se verifica que el stack no este vacio, o preceda un CAA diferemnte a {
                if(stack.isEmpty() || stack.top() == '(' || stack.top() == '[')
                    return false;
                stack.pop();        //Se hace un pop del stack
            }
        }
        return stack.isEmpty();     //Si el stack esta vacio, todos los CAA estan debidamente balanceados 
    }
}
