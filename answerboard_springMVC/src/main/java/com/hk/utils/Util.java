package com.hk.utils;

public class Util {
   
   private String arrowNbsp;//depthũ�⸸ŭ ���� ����°� ����


   //�Խñ��� depth��ũ�⸸ŭ ������ ����� ���
   public void setArrowNbsp(String depth) {
      String nbsp="";
      int depthInt=Integer.parseInt(depth);//int������ ����ȯ
      for (int i = 0; i < depthInt; i++) {
         nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";
      }
      //����?true:false--->3�׿�����
      this.arrowNbsp=(depthInt>0?nbsp+"<img src='img/arrow1.png' alt='���'/>":"");
   }
   
   public String getArrowNbsp() {
      return arrowNbsp;
   }
   
}