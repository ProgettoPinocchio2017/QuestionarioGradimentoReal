
import Model.Video;
import testvideo4.TestVideo4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */public class main{
public static void main(String[] args) {
    Video a=new Video("F:\\Manuel\\Rally\\","città lucca 2015.mp4");
      System.out.println(a.getName());
       
    TestVideo4 b=new TestVideo4();
  
    b.setvideo(a);
    
    System.out.println(b.getVideo());
    b.avvio("");
}
 }
