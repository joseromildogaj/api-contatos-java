package br.com.jr.contatos.exceptions;

public class ExistingEmailException extends RuntimeException{
    public ExistingEmailException(String msg){
        super(msg);
    }
}
