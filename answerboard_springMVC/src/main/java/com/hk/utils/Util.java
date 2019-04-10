package com.hk.utils;

public class Util {
   
   private String arrowNbsp;//depth크기만큼 공백 만드는거 저장


   //게시글의 depth의크기만큼 공백을 만드는 기능
   public void setArrowNbsp(String depth) {
      String nbsp="";
      int depthInt=Integer.parseInt(depth);//int형으로 형변환
      for (int i = 0; i < depthInt; i++) {
         nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";
      }
      //조건?true:false--->3항연산자
      this.arrowNbsp=(depthInt>0?nbsp+"<img src='img/arrow1.png' alt='답글'/>":"");
   }
   
   public String getArrowNbsp() {
      return arrowNbsp;
   }
   
}