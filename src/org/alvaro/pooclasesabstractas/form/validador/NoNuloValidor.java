package org.alvaro.pooclasesabstractas.form.validador;

public class NoNuloValidor extends Validador{

    protected String mensaje = "el campo %s no puede ser nulo";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null);
    }
}
