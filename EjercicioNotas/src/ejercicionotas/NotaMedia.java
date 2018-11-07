package ejercicionotas;

import javax.swing.JOptionPane;

public class NotaMedia {
    // lista de diferentes variables que usaremos (pendiente de acotar)
    private double nota;
    private int boletines;
    private int boletinesAlumno;
    private int numAlumnos;
    private int notaBoletinesF;
    private double notaTeoricaFinal;
    private double notaPractica;
    private int i;
    
public double setNota(){ //Validación de las notas que pedimos
        do{
        nota = Double.parseDouble(JOptionPane.showInputDialog("Introduce la nota deseada: "));
        if (nota < 0 || nota > 10) // No puede ser negativa ni mayor a 10.
            JOptionPane.showMessageDialog(null,"La nota introducida es incorrecta, vuelve a introducirla: ");
        }while(nota < 1 || nota > 10); // repetimos mientras no den un valor adecuado.
        return nota;
        }

public int setNumeroBoletines(){ // Validación del numero total de boletines
    do {
    boletines = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero total de boletines realizados: "));
    if (boletines <= 0) // No puede ser igual o menor que cero.
        JOptionPane.showMessageDialog(null, "El numero total de boletines no puede ser cero o menor");
    }while (boletines <= 0);
    return boletines;
    }

public int setNumeroBoletinesAlumno(){ // Validación del numero de boletines entregados por el alumno.
    do {
    boletinesAlumno = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de boletines realizados por el alumno"));
    if (boletinesAlumno < 0 || boletinesAlumno > boletines) // No pueden ser negativos o mayores al numero total de boletines
        JOptionPane.showMessageDialog(null, "El numero de boletines realizado por el alumno no puede ser negativo o mayor que el numero de boletines totales");
    }while (boletinesAlumno < 0 || boletinesAlumno > boletines);
    return boletinesAlumno;
}

public double darNotaTeorica(){ // calculamos la nota teorica
    JOptionPane.showMessageDialog(null, "La nota del primer examen teorico");
    double notaTeorica1 = setNota(); // Asignamos un valor introducido por metodo al primer examen
    JOptionPane.showMessageDialog(null, "La nota del segundo examen teorico");
    double notaTeorica2 = setNota(); // Asignamos un valor introducido por metodo al segundo examen
    notaTeoricaFinal =notaTeorica1 * notaTeorica2 / 2 * 0.4; // calculo de la nota teorica total
    return notaTeoricaFinal;
}

public double darNotaPractica(){
    JOptionPane.showMessageDialog(null, "La nota del proyecto: ");
    notaPractica = setNota() * 0.4; // Recogemos valor por metodo, hacemos calulo y se lo asigano a la nota final practica
    return notaPractica;
}

public int darNotaBoletines(){
    int boletinesT = setNumeroBoletines(); // asigno el numero total de boletines
    int boletinesA = setNumeroBoletinesAlumno(); // asigno el numero boletines realizados por el alumno 
    double notaBoletines = boletinesA / boletinesT * 100; // calculo del porcentaje que realizo el alumno
    if (notaBoletines < 70){ // con los if compruebo que valor le asigno a la nota final de los boletines en función del porcentaje de entregados 
        notaBoletinesF = 0;
    }
    else if (notaBoletines < 90){
        notaBoletinesF = 1;
    }
    else {
        notaBoletinesF = 2;
    }
    return notaBoletinesF;
}


public int darNumAlumnos(){ // validación del numero de alumnos
       do{
        numAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de alumnos: "));
        if (numAlumnos <= 0)
            JOptionPane.showMessageDialog(null,"Debe existir al menos un alumno, intentalo de nuevo: ");
       }while (numAlumnos <= 0);
       return numAlumnos;
}

public void calcularNotaMedia(){
    for(i = 0; i < numAlumnos; i++ ){ // bucle for para que ejecute las instrucciones el mismo numero de veces que de alumnos
      darNotaTeorica(); darNotaPractica(); darNotaBoletines(); // ejecutamos los metodos en orden para conseguir las distintas notas que componen la nota final 
      int notaFinal =(int)(notaTeoricaFinal * 0.4 + notaPractica * 0.4 + notaBoletinesF * 0.2); // calculo de la notaFinal del alumno con conversion de tipos (sin decimales)
      JOptionPane.showConfirmDialog(null,"La nota final del alumno sera: " + notaFinal);
    }
}    

}
