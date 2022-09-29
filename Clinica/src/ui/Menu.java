package ui;

import java.util.Scanner;
import misc.Condicional;

public class Menu implements IMenu{
    private final Scanner sc=new Scanner(System.in);
    private final MenuServicio a=new MenuServicio();
    private String v;
    private int cont;
    
    @Override
    public void Menu(){
        System.out.println("_________________________________________________________________________________");
        System.out.print("1.Contratar servicio"
                + "\n2.Ver servicio"
                + "\n3.Salir"
                + "\nEscoja la opcion deseada: ");
    }
    
    @Override
    public void showMenu(){
        cont=0;
        v="";
        String opc;
        VerServicios b = new VerServicios();
        OUTER:
        do{
        Menu();
        opc=sc.next();
        if( null == opc)System.out.println("Opcion invalida");
        else switch (opc) {
                case "1" -> {
                    a.showMenu();
                    v=v+a.getPaciente();
                    cont=cont+a.getDeuda();
            }
                case "2" -> b.showMenu();
                case "3" -> {
                    System.out.println("Tenga un buen día");
                    break OUTER;
                }
                default -> System.out.println("Opcion invalida");
            }
        
        }
        while(!"3".equals(opc));
    }
    public String getPaciente(){
        if("".equals(v))return "No hizo uso de ningun servicio";
        return Condicional.Ficha("\n"+v+"\nDeuda= "+cont);
    }
}

