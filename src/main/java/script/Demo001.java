package script;

import cn.hutool.core.util.HexUtil;
import cn.hutool.json.JSONUtil;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Demo001 {

    public static void main(String[] args) {
        char[] kunjinkao = HexUtil.encodeHex("��", StandardCharsets.UTF_8);
        System.out.println(kunjinkao);

        byte[] testBytes = HexUtil.decodeHex(kunjinkao);
        System.out.println(new String(testBytes, Charset.forName("GBK")));
    }




}
