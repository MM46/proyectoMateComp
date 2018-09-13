/*        //SUFIJO=POSTFIJO
 *         Para saber si es sufijo
 *
 *         procedure COMPUTE_TRANSITION_FUNCTION(alphabet, pattern):
 *             m=pattern.lenght
 *             matrix[][]
 *             for q=0 until q=m{
 *                 for each a in alphabet{
 *                     k=min(m+1, q+2)
 *
 *                     do{
 *                         k=k-1
 *                     }while(Pk incluya Pqa como sufijo) //pk es una fracción de patterns
 *                     matrix[q][a.index]=k
 *                 }
 *             }
 *         return matrix
 *
 *     ArrayList de hashpmaps(hashtables)
 *
 *
 *         procedure main():
 *             READ alphabet
 *             READ pattern
 *             READ string
 *
 *
 *
 */

import java.util.Scanner;
import java.lang.*;

public class Main {
    
    public static void print_matrix(int[][]matrix, int al, int  pl) {
        for(int i=0; i<=pl; i++) {
            for(int j=0; j<al; j++) {
                System.out.print("|"+matrix[i][j]+"|");
            }System.out.println("\n");
        }
    }
    
    
    public static int[][] compute_transition_function(String alphabet, String pattern) {
        int m=pattern.length();
        int k, indexC;
        int matrix[][]= new int[100][100];
        System.out.println(matrix.toString());
        String pk, pq=null;
        
        pk=pattern.substring(0,1);
        
        for(int q = 0; q<=m; q++) {
            indexC=0;
            for(char c: alphabet.toCharArray()) {
                k=Math.min(m+1, q+2);
                
                pq=pattern.substring(0,q)+c;
                
                do {
                    k=k-1;
                    pk=pattern.substring(0,k);
                    
                }while(!pq.endsWith(pk)); //Hasta que Ak sea el sufijo de Aqx crear mi propio ends with
                matrix[q][indexC]=k;
                indexC++;
            }//for each
        }//for
        return matrix;
    }//return delta tansitions table
    
    
    public static int finit_automation_matcher(String t, int [][]matrix, int m, String alfabeto) {
        int n=t.length();    //t es nuestra cadena
        int q=0;
        int counter=0;
        char auxt[]=t.toCharArray();
        for(int i=1; i<=n; i++) {
            q=matrix[q][index_t(auxt[i-1], alfabeto)];
            
            if(q==m) {
                //System.out.println("Pattern occurs");
                counter++;
            }
            
        }return counter;
    }
    
    public static int index_t(char caracter, String alfabeto) {
        
        char[] alfa=alfabeto.toCharArray();
        int i=0;
        
        for(i=0; i<alfabeto.length(); i++) {
            if(alfa[i]==caracter) {
                return i;
            }
            
        }
        return 0;
    }
    
    
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int mat[][]=new int[100][100];
        String alphabet, pattern, cad;
        
        
        while(teclado.hasNextLine()) {
            alphabet=teclado.nextLine();
            pattern=teclado.nextLine();
            cad=teclado.nextLine();
            
            mat=compute_transition_function(alphabet, pattern);
            
            compute_transition_function(alphabet, pattern);
            
            System.out.println(finit_automation_matcher(cad, compute_transition_function(alphabet, pattern), alphabet.length(), alphabet));
            //print_matrix(mat, alphabet.length(), pattern.length());
        }
        //System.out.println("Starting...");
        teclado.close();
        
    }
}
