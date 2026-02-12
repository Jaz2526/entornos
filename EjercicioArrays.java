package ProblemaArray;
import java.util.Arrays;
import java.util.List;

public class EjercicioArrays {
    public static void main(String[] args) {
        int numAlumnos = 40;
        //vector con las notas generadas
        Integer[] control = new Integer[numAlumnos];
		int[] listaClase;
		int[] practicas;
		float[] calificaciones;
		float[] estadistica;
		int[] aprobados;
		int[] suspensos;
        int maxNota = 0;
        int minNota = 0;
        int indMaxNota, indMinNota;
        int postEval;
        int postEval2;
		double[] calif;
       
        postEval = 11;
        postEval2 = 0;
        listaClase = new int[numAlumnos];
        practicas = new int[numAlumnos];
        calificaciones = new float[numAlumnos];
        aprobados = new int[numAlumnos];
        suspensos = new int[numAlumnos];
        int countAprobados = 0;
        int countSuspensos = 0;
        
         //Genera notas random entre 1 y 10, buscamos mayor y menor, creamos una lista de los alumnos de la clase, las calificaciones y las prácticas 
        //Varios procesos se pueden realizar en un mismo bucle puesto que los arrays son del mismo tamaño
        for(int i=0; i<control.length; i++){
        	//Asignamos notas aleatorias en control, los numeros en la lista de clase y las notas de prácticas
        	control[i] = (int)(Math.random()*11);
        	listaClase[i] = i+1;
        	practicas[i] = (int)(Math.random()*11);
        	
        	//calculamos las calificaciones:
        	 calificaciones[i] = (((float) control[i]+ (float) practicas[i])/ 2);
        	
        	 //Aprobados y suspensos:
        	 if (calificaciones[i] < 5){
                 aprobados[i] = i;
                 countAprobados += 1;
             }else{ 
                 suspensos[i] = i;
                 countSuspensos += 1;
             }
        	 
        	//comprobación mayor y menor
            int preEval = control[i];
            if (preEval < postEval){
                minNota = preEval;
                postEval = control[i];
            }
            int preEval2 = control[i];
            if(preEval2 > postEval2){
                maxNota = preEval2;
                postEval2 = control[i];
            }
        }
         
        //Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        indMinNota = notas.indexOf(minNota) + 1;
        indMaxNota = notas.indexOf(maxNota) + 1;

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo es: " + minNota +"\nMáximo es: " + maxNota + "\nIndice del mínimo es : " + indMinNota + "\nIndice del máximo es : " + indMaxNota + "\nLista de clase :" + Arrays.toString(listaClase) + "\nArray de Notas :" + notas );
        System.out.println("Prácticas      :" + Arrays.toString(practicas) + "\nCalificaciones :" + Arrays.toString(calificaciones));
        
        //Sacamos la estadística de calificaciones y hacemos un array de 10 para la estadística.
        estadistica = new float[10];

        for (int i=0; i<10; i++){
            float count = 0;
            float sum = 0;
            for (int j=0; j<control.length; j++){
                if ((i < calificaciones[j]) && ((i+1) >= calificaciones[j] )) {
                    sum += calificaciones[j];
                    count += 1;
                }
            }
            if (count != 0){
                estadistica[i] = ( (float)count / numAlumnos);
            }else{ estadistica[i] = 0;}
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <=" 
                + (i+1) + " = " 
                + sol + "%");
        }
        
        System.out.println("Relación de aprobados por nº de lista: " + Arrays.toString(aprobados) + "\nRelación de suspensos por nº de lista: " + Arrays.toString(suspensos));
        //Resumen de aprobados y suspensos
        int i = 0;
        int x = 0;
        int[] a = new int[countAprobados];
        int[] s = new int[countSuspensos];
        while(i < aprobados.length){
            if(aprobados[i] != 0){
                a[x] = aprobados[i];
                i++;
                x++;
            }else{ i++; }
        }
        
        i = x = 0;
        while(i < suspensos.length){
            if(suspensos[i] != 0){
                s[x] = suspensos[i];
                i++;
                x++;
            }else{ i++; }
        }
        System.out.println("Resumen  de aprobados por nº de lista: " + Arrays.toString(a) + "\nResumen  de aprobados por nº de lista: " 
                + Arrays.toString(s));
        
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        calif = new double[40];
        for (int j=0; j<31; j++){
            calif[j] = (int)(Math.random()*11);
        }
        System.out.println("Nota antigua alumno nº4: " + calif[3]); 
        calif[3] = 6;
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }
}
