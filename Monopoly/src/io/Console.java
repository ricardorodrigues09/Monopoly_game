package io;
import java.util.Scanner;
import java.io.*;


public class Console {

  protected BufferedReader fluxIn = new BufferedReader(
	new InputStreamReader(System.in));

  private boolean ok;

  public Console() {
    fluxIn = new BufferedReader(new InputStreamReader(System.in));
  }

  
  public String readLine(){
    String input = null;
    try{
	input = fluxIn.readLine();
    }
    catch(IOException e){
	System.out.println(e.getMessage());
	System.exit(0);
    }
    return input;
  }


  public int readInt(){
    int res = 0 ;
    do{
      try{res = Integer.parseInt(this.readLine()); ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return res;
  }

  public String strInput() {
	  Scanner keyboard = new Scanner(System.in);
	  return keyboard.nextLine();
	  }

  public short readShort(){
    short result = 0 ;
    do{
      try{ result = Short.parseShort(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  public byte readByte(){
    byte result = 0 ;
    do{
      try{ result = Byte.parseByte(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }

  public long readLong(){
    long result = 0 ;
    do{
      try{ result = Long.parseLong(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }

  public double readDouble(){
    double result = 0 ;
    do{
      try{ result = Double.parseDouble(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }

  public float readFloat(){
    float result = 0 ;
    do{
      try{ result = Float.parseFloat(this.readLine());ok = true;}
      catch(NumberFormatException e){ok = false;}
    }while(!ok);
    return result;
  }


  public void println(String s){
    System.out.println(s);
  }

  public void print(String s){
    System.out.print(s);
  }

  public void println(Object s){
    System.out.println(s);
  }


  public void print(Object s){
    System.out.print(s.toString());
  }

  public void println(int s){
    System.out.println(String.valueOf(s));
  }

  public void print(int s){
    System.out.print(String.valueOf(s));
  }

  public void println(long s){
    System.out.println(String.valueOf(s));
  }

  public void print(long s){
    System.out.print(String.valueOf(s));
  }


  public void println(short s){
    System.out.println(String.valueOf(s));
  }

  public void print(short s){
    System.out.print(String.valueOf(s));
  }

  public void println(byte s){
    System.out.println(String.valueOf(s));
  }


  public void print(byte s){
    System.out.print(String.valueOf(s));
  }

  public void println(double s){
    System.out.println(String.valueOf(s));
  }

  public void print(double s){
    System.out.print(String.valueOf(s));
  }

  public void println(float s){
    System.out.println(String.valueOf(s));
  }


  public void print(float s){
    System.out.print(String.valueOf(s));
  }

  public void println(boolean s){
    System.out.println(String.valueOf(s));
  }

  public void print(boolean s){
    System.out.print(String.valueOf(s));
  }
}