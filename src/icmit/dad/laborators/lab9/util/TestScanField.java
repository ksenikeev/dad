package icmit.dad.laborators.lab9.util;

import icmit.dad.laborators.lab9.annotations.Column;
import icmit.dad.laborators.lab9.annotations.Id;
import icmit.dad.laborators.lab9.annotations.Table;
import java.lang.reflect.Field;

public class TestScanField {
    public static void main(String[] args){
        try {
            Class cl = Class.forName("icmit.dad.laborators.lab9.domain.Contact");

            Class superCl = cl.getSuperclass();
            Field[] sfields = superCl.getDeclaredFields();
            for(Field f : sfields){
                if (f.isAnnotationPresent(Id.class))
                    System.out.println(f.getName() + " is Id");
                if (f.isAnnotationPresent(Column.class)) {
                    System.out.println(f.getName() + " is column of table, name: ");
                }
            }


            if (cl.isAnnotationPresent(Table.class)){
                System.out.println(cl.getCanonicalName() +" is table");
                Field[] fields = cl.getDeclaredFields();
                for(Field f : fields){
                    if (f.isAnnotationPresent(Id.class))
                        System.out.println(f.getName() + " is Id");
                    if (f.isAnnotationPresent(Column.class)) {
                        Column c = f.getAnnotation(Column.class);
                        System.out.println(f.getName() + " is column of table, name: "+c.name());
                    }
                }

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
