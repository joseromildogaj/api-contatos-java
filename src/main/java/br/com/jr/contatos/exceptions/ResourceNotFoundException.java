package br.com.jr.contatos.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
