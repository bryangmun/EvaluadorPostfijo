/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        String operacion = null;
        int x;
        int y;
        int operado = 0;
        for (int i = 0; i < expresion.size(); i++ )
        {
            if (!expresion.get(i).equals("+") && !expresion.get(i).equals("-") && !expresion.get(i).equals("*") && !expresion.get(i).equals("/"))
            {
                pila.push(Integer.parseInt(expresion.get(i)));
                continue;
            }
            else {
                operacion = expresion.get(i);

                if (operacion.equals("+")) {
                    x = pila.pop();
                    y = pila.pop();
                    operado = y + x;
                    pila.push(operado);
                    continue;
                }
                if (operacion.equals("-")) {
                    x = pila.pop();
                    y = pila.pop();
                    operado = y - x;
                    pila.push(operado);
                    continue;
                }
                if (operacion.equals("*")) {
                    x = pila.pop();
                    y = pila.pop();
                    operado = y * x;
                    pila.push(operado);
                    continue;
                }
                if (operacion.equals("/")) {
                    x = pila.pop();
                    y = pila.pop();
                    operado = y / x;
                    pila.push(operado);
                    continue;
                }
            }
        }

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
