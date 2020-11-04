package org.alvaro.pooclasesabstractas.form;

import org.alvaro.pooclasesabstractas.form.elementos.*;
import org.alvaro.pooclasesabstractas.form.elementos.select.Opcion;
import org.alvaro.pooclasesabstractas.form.validador.LargoValidador;
import org.alvaro.pooclasesabstractas.form.validador.NoNuloValidor;
import org.alvaro.pooclasesabstractas.form.validador.NumeroValidador;
import org.alvaro.pooclasesabstractas.form.validador.RequeridoValidador;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("password", "password");
        password.addValidador(new RequeridoValidador())
            .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidor());

        lenguaje.addOpcion(new Opcion("1", "Java"))
        .addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JS"))
        .addOpcion(new Opcion("4", "TypeScript").setSelected())
        .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo"){

            @Override
            public String dibujarHtml() {
                return "<input disabled name '"+ this.nombre+ "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola, este campo esta disabled");
        username.setValor("Alvaro.Arguelles");
        password.setValor("12345");
        email.setValor("alvaro@gmail.com");
        edad.setValor("21");
        experiencia.setValor("6 meses de experiencia");
//        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, experiencia, lenguaje, saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });
    }
}
