package icmit.dad.laborators.lab9.util;

import icmit.dad.laborators.lab9.annotations.Column;
import icmit.dad.laborators.lab9.annotations.Id;
import icmit.dad.laborators.lab9.annotations.Table;
import java.lang.reflect.Field;

public class TestScanField {
    public static void main(String[] args){
        try {
            Class cl = Class.forName("icmit.dad.laborators.lab9.domain.Contact");

            if (cl.isAnnotationPresent(Table.class)){
                // Получаем аннотацию типа Table
                Table t = (Table) cl.getAnnotation(Table.class);
                // Выводим имя класса и атрибут name аннотации Table
                System.out.println("Class "+ cl.getSimpleName() +" is table, name: " + t.name());

                // Считываем все члены класса, начиная с членов родительского класса
                Class superCl = cl.getSuperclass();
                Field[] sfields = superCl.getDeclaredFields();

                // Перебираем поля, определяем наличие известных аннотаций, выводим значение атрибута
                for(Field f : sfields){
                    if (f.isAnnotationPresent(Id.class))
                        System.out.println(f.getName() + " is Id");
                    if (f.isAnnotationPresent(Column.class)) {
                        Column c = f.getAnnotation(Column.class);
                        System.out.println(f.getName() + " is column of table, name: "+c.name());
                    }
                }

                // Перебираем поля, определяем наличие известных аннотаций, выводим значение атрибута
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
