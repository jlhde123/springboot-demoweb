package com.jlh.demowork.core.utils;

import com.jlh.demowork.core.exceptions.AbstractException;
import com.jlh.demowork.core.exceptions.ServerException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 9:56
 * Description:
 */
public class PasswordUtils {

    private static final Random r = new Random(System.currentTimeMillis());
    private static final int saltLength = 8 ;
    private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };


    /**
     * @param password 密码加盐
     * @return 加盐串
     */
    public static String encrpty (String password){

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0;i<saltLength;i++){
                stringBuilder.append(hexDigits[r.nextInt(hexDigits.length)]);
            }
            String salt = stringBuilder.toString();
            mdTemp.update(salt.getBytes());
            mdTemp.update(password.getBytes());
            return byteToHex(mdTemp.digest())+salt;
        } catch (Exception e) {
            throw new ServerException(e);
        }
    }

    /**
     * @param source 加盐串
     * @param compare 比较的密码
     */
    public static boolean verity(String source,String compare){
        try {
            String md5Str = source.substring(0,32);
            String salt = source.substring(32);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(salt.getBytes());
            mdTemp.update(compare.getBytes());
            return byteToHex(mdTemp.digest()).equals(md5Str);
        }catch (Exception e){
            throw new ServerException(e);
        }
    }


    public static String byteToHex(byte[] dig) {
        int j = dig.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = dig[i];
            str[k++] = hexDigits[byte0 >>> 4 & 15];
            str[k++] = hexDigits[byte0 & 15];
        }
        return new String(str);
    }

}
