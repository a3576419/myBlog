package com.aioe.test.demo.utils;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static String md5Code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int j = 0; j < digest.length; j++) {
                i = digest[j];
                if (i<0){
                    i+=256;
                }if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void test(){
        System.out.println(md5Code("1"));
    }
}
