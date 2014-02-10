package boletin19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class Alumno implements Comparable {//implemento a interface comparable para poder sobreescribilo metodo compareTo

    private String nome;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    public static void introAlumno(ArrayList<Alumno> nomearray) {
        int not;
        String nom;
        String saida = "0";

        do {
            nom = JOptionPane.showInputDialog("Introduce nome do alumno " + (nomearray.size() + 1));
            do {
                not = Integer.parseInt(JOptionPane.showInputDialog("Introduce nota do alumno " + (nomearray.size() + 1)));
                if (not == 0 || not >= 10) {
                    JOptionPane.showMessageDialog(null, "a nota a de estar comprendida entre 1 e 10");
                }
            } while (not == 0 || not >= 10);
            nomearray.add(new Alumno(nom, not));
            saida = (JOptionPane.showInputDialog("0-Sair \nCalquera tecla- introducir outro alumno"));
        } while (saida.compareTo("0") != 0);

    }

    @Override
    public String toString() {//sobreescribo este método, para cando faga un get(i) saiaba directamente que imprimirme
        String res = (" nome: " + nome + " \tnota: " + this.getNota());//podo por a variable directamente ou con this.get..
        return res;
    }

    public static void verFor(ArrayList<Alumno> nomearray) {
        for (int i = 0; i < nomearray.size(); i++) {
            System.out.println(nomearray.get(i));//podo facelo con get(i) por que sobrescribin o metodo toString
        }
        System.out.println("");
    }

    public static void verForeach(ArrayList<Alumno> nomearray) {
        //System.out.println("nome \tnota");//formateo se non sobreescribise toString
        for (Alumno i : nomearray) {
            System.out.println(i);
            // System.out.println(i.getNome()+"\t"+i.getNota()); //Seria o que poria se non sobrescribise metodo toString
        }
        System.out.println("");
    }

    public static void verIterator(ArrayList<Alumno> nomearray) {
        Iterator it = nomearray.iterator(); //crease iterador it para o noso arraylist
        while (it.hasNext()) //mentras queden elementos
        {
            System.out.println(it.next());  //obteñense y mostranse      
        }
        System.out.println("");
    }

    public static void verNota(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        do {
            String nom = JOptionPane.showInputDialog("Introduce nome do alumno do cal queres saber a nota");
            for (int i = 0; i < nomearray.size(); i++) {
                if (nom.equalsIgnoreCase(nomearray.get(i).getNome())) {
                    posicion = i;
                }
            }
            if (posicion == -1) {
                JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
            }
        } while (posicion == -1);
        JOptionPane.showMessageDialog(null, nomearray.get(posicion));
        //JOptionPane.showMessageDialog(null, "a nota do alumno é " + nomearray.get(posicion).getNota());//o que poria se non sobreescribise o metodo toString
    }

    public static void borraAlumno(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        String nom = JOptionPane.showInputDialog("Introduce nome do alumno que queres eliminar");
        Alumno obx = new Alumno(nom, 0);//creo un obxecto para que poida ser comparado

        //Sin métodos sobrescritos
         for (Alumno i : nomearray) {
         if (i.compareTo(obx) == 0) {//podo facelo así por que teño o método comapareTO sobreescrito
         posicion = nomearray.indexOf(i);
         }
         }
         

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
        } else {
            nomearray.remove(posicion);
            JOptionPane.showMessageDialog(null, "o alumno " + nom + " foi borrado");

  
        }

    }

    public static void ordear(ArrayList<Alumno> nomearray) {
        Collections.sort(nomearray);//Como tenemos sobreescrito el compareTo-->ya ordena por nombre.
 
    }
  
    public static void consultaAlumno(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        String nom = JOptionPane.showInputDialog("Introduce nome do alumno que queres saber se está");
        Alumno obx = new Alumno(nom, 0);//creo un obxecto para que poida ser comparado
        
         for (Alumno i : nomearray) {
         if (i.compareTo(obx) == 0) {
         posicion = nomearray.indexOf(i);
         }
         }

         if (posicion == -1) {
         JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
         } else {
        JOptionPane.showMessageDialog(null, "o alumno " + nomearray.get(posicion) + " está na lista");

         }

    }

    @Override
    public int compareTo(Object o) {//sobreescribo o metodo compare to para que sepa como ten que comparar o obxecto
        Alumno al = (Alumno) o;//fago cast por que recibo un obxecto tipo obxect-->teño que pasalo a miña clase (alumno)
        //Non poño para recibir directamente como parametro o obxecto alumno no método para non cambiar 
        // a sinatura da inteface
        if (this.nome.compareToIgnoreCase(al.nome) == 0) {
            return 0;
        } else if (this.nome.compareToIgnoreCase(al.nome) > 0) {
            return 1;
        } else {
            return -1;
        }
    }


    //http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Arrays.java#Arrays.ArrayList
//ver página para ver como extender array ArrayList
  

}