package com.connor.jdk.decode;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAdemo {

    private static Map<Integer, String> keyMap = new HashMap<>();


    public static void main(String[] args) throws Exception {

        genKeyPair();
        Character m = '我';
        String message = "我我我我我我我"
                + "我我我我我我我"
                + "我我我我我我我"
                + "我我我我我我我"
                + "我我我我我我我"
                + "我我我我我我我"
                + "我我我我我我我";
        System.out.println(message.getBytes().length);

        String encryptNoPadding = encryptNoPadding(message, keyMap.get(0));
        String decryptNoPadding = decryptNoPadding(encryptNoPadding, keyMap.get(1));

        String encrypt = encrypt(message, keyMap.get(0));
        String decrypt = decrypt(encrypt, keyMap.get(1));

        System.out.println(encrypt);
        System.out.println(decrypt);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥

        byte[] publicEncode = publicKey.getEncoded();
        byte[] privateEncode = privateKey.getEncoded();
        System.out.println(publicEncode.length);
        System.out.println(privateEncode.length);

        String publicKeyString = new String(Base64.encodeBase64(publicEncode));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateEncode)));
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString);  //0表示公钥
        keyMap.put(1, privateKeyString);  //1表示私钥

//        System.out.println("publicKey:" + publicKeyString);
//        System.out.println("privateKey:" + privateKeyString);


    }


    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    /**
     * RSA私钥加密
     *
     * @param str
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String privateKeyEncrypt(String str, String privateKey, String point) throws Exception {
        //log.info("{}|RSA私钥加密前的数据|str:{}|publicKey:{}",point,str,privateKey);
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").
                generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes()));
        //log.info("{}|RSA私钥加密后的数据|outStr:{}",point,outStr);
        return outStr;
    }

    /**
     * RSA公钥解密
     *
     * @param str
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String publicKeyDecrypt(String str, String publicKey, String point) throws Exception {
        //log.info("{}|RSA公钥解密前的数据|str:{}|publicKey:{}",point,str,publicKey);
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        String outStr = new String(cipher.doFinal(inputByte));
        //log.info("{}|RSA公钥解密后的数据|outStr:{}",point,outStr);
        return outStr;
    }

    public static String encryptNoPadding(String plainText, String publicKey) throws Exception {


        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));


        Cipher encryptCipher = Cipher.getInstance("RSA/ECB/NoPadding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);


        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes("utf-8"));

        return Base64.encodeBase64String(cipherText);
    }

    public static String decryptNoPadding(String cipherText, String privateKey) throws Exception {

        byte[] bytes = Base64.decodeBase64(cipherText.getBytes("UTF-8"));
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").
                generatePrivate(new PKCS8EncodedKeySpec(decoded));


        Cipher decriptCipher = Cipher.getInstance("RSA/ECB/NoPadding");
        decriptCipher.init(Cipher.DECRYPT_MODE, priKey);

        return new String(decriptCipher.doFinal(bytes), "utf-8");
    }
}
