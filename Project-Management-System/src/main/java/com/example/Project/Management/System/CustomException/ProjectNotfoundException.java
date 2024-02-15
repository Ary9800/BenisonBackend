package com.example.Project.Management.System.CustomException;

public class ProjectNotfoundException extends RuntimeException{
    public ProjectNotfoundException(String error){
        super(error);
    }

}
