package com.company;

import com.company.server.InitServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	try{
	    new InitServer("localhost", 8988).start();
    }catch (IOException ex){
	    ex.printStackTrace();
    }
    }
}
