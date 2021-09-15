package com.dotori.golababvoteserver.exception;

public class NotValidNumOfVoteException extends RuntimeException{

    public NotValidNumOfVoteException(){
        super();
    }
    public NotValidNumOfVoteException(String message){
        super(message);
    }
}
