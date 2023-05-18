package com.example.demo.utils;



import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.UnsupportedEncodingException;


/**
 * sm4加密解密
 * CBC模式
 *
 * @author wwl
 */

public class SM4Utils {
    /**
     * 和前端key一致(上面提到的需要一致的地方)
     */
    private static String secretKey = "14BB7EEE7FCB3099";

    /**
     * 和前端iv一致
     */
    private static String iv = "117223BC37E9080C";


    /**
     * cbc解密
     *
     * @param cipherTxt
     * @return
     */
    public static String decrypt(String cipherTxt) {
        String plainTxt = "";
        try {
            //这里是new的SM4类的方法，SmUtil里的方法满足不了需求
            SymmetricCrypto sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding,
                    secretKey.getBytes(CharsetUtil.CHARSET_UTF_8),
                    iv.getBytes(CharsetUtil.CHARSET_UTF_8));
            byte[] cipherHex = Base64.decode(cipherTxt.trim());
            plainTxt = sm4.decryptStr(cipherHex, CharsetUtil.CHARSET_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainTxt;
    }


    /**
     * cbc加密
     *
     * @param plainTxt
     * @return
     */
    public static String encrypt(String plainTxt) {
        String cipherTxt = "";
        SymmetricCrypto sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding,
                secretKey.getBytes(CharsetUtil.CHARSET_UTF_8),
                iv.getBytes(CharsetUtil.CHARSET_UTF_8));
        byte[] encrypHex = sm4.encrypt(plainTxt);
        cipherTxt = Base64.encode(encrypHex);
        return cipherTxt;
    }

}
