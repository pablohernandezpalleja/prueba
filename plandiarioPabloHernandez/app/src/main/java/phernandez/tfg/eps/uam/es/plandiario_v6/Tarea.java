package phernandez.tfg.eps.uam.es.plandiario_v6;

import java.util.Date;

/**
 * Created by Pablo on 3/1/18.
 */

public class Tarea {
    public int idTarea;
    public String titulo;
    public Date fecha;
    public int idImg;

    public Tarea(int idTarea,String titulo,String fecha,int idImg){
        this.idTarea=idTarea;
        this.titulo=titulo;
        this.fecha=setFecha(fecha);
        this.idImg=idImg;
    }

    public String getFecha(){
        String fecha = "";
        fecha=this.fecha.getDay()+"/"+this.fecha.getMonth()+"/"+this.fecha.getYear();
        return fecha;
    }

    public Date setFecha(String fecha){
        String partes[] = fecha.split("/");
        int day = Integer.parseInt(partes[0]);
        int month = Integer.parseInt(partes[1]);
        int year = Integer.parseInt(partes[2]);
        Date d = new Date(year,month,day);
        System.out.println(d.toString());
        return d;
    }

}
