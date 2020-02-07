package com.hyw.cart;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.Iterator;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/7 14:52
 * Description：TODO
 */
public class MultisetTest {

    private static final String poem = "南陵别儿童入京_百度汉语"+
            "作者：李白"+
            "白酒新熟山中归，黄鸡啄黍秋正肥。"+
            "呼童烹鸡酌白酒，儿女嬉笑牵人衣。"+
            "高歌取醉欲自慰，起舞落日争光辉。"+
            "游说万乘苦不早，著鞭跨马涉远道。"+
            "会稽愚妇轻买臣，余亦辞家西入秦。"+
            "仰天大笑出门去，我辈岂是蓬蒿人。";

    @Test
    public void handler(){
        Multiset<Character> multiset = HashMultiset.create();
        char[] chars = poem.toCharArray();
        Chars.asList(chars)
                .stream()
                .forEach(charItem -> multiset.add(charItem));

        System.out.println(multiset.count('人'));
        System.out.println(multiset.size());

    }

}
