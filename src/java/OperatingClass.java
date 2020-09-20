/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAF
 */
public class OperatingClass {

 private int number1;
 private int number2;
 private String operator;
 private double result2;
 private int result1;
 
 public OperatingClass(int number1, int number2, String operator) {
  this.number1 = number1;
  this.number2 = number2;
  this.operator = operator;
 }
 
 public void calc() {
   switch(operator) {
      case "+":
       result1=number1+number2;
       break;
      case "-":
       result1=number1-number2;
       break;
      case "*":
       result1=number1*number2;
       break;
      case "/":
       result2=(double)number1/(double)number2;
       break;
      }
 }
 
 public int getResult1() {
  return result1;
  
 }
 public double getResult2() {
  return result2;
 }
}