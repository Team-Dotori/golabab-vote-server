package com.dotori.golababvoteserver.advie;

public class NotValidNumOfVoteException extends RuntimeException{

    public NotValidNumOfVoteException(){
        super();
    }
    public NotValidNumOfVoteException(String message){
        super(message);
    }
}
