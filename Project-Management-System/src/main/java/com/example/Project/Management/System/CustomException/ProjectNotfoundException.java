package com.example.Project.Management.System.customException;

public class projectNotfoundException extends RuntimeException{
    public projectNotfoundException(String error){
        super(error);
    }

}
