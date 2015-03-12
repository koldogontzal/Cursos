/*
 * Calculadora.java
 *
 * Created on 29 de junio de 2007, 2:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ejercicioswing;

/**
 *
 * @author Arturo Gomez del C
 */
public class Calculadora {  
    private int op1;
    private int op2;
    
    /** Creates a new instance of Calculadora */
    public Calculadora() {
        this.op1 = 0;
        this.op2 = 0;
    }
    
    public int sumar(){        
        this.op1 = this.op1 + this.op2;
        return this.op1;        
    }
    
    public int restar(){        
        this.op1 = this.op1 - this.op2;
        return this.op1;
    }
    
    public int multiplicar(){        
        this.op1 = this.op1 * this.op2;
        return this.op1;
    }    

    public void agregarOperando(int operando) {
        if (this.op1==0)
            this.op1 = operando;
        else this.op2 = operando;
    }
}
