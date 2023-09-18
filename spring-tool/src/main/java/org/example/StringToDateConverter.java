package org.example;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2023/9/15
 * @Author: Administrator
 * @ClassName: StringToDateConvertor
 * @Description: Converter是个能替代 PropertyEditor 的接口，它实现了从某种类型到某种类型的转化
 *               所以也能实现 String 类型到某种类型的转化，故能替代 PropertyEditor
 *               用在什么场景呢？比方说，不再是字符串转换为类型，而是B类型需要转化为A类型，
 */

public class StringToDateConverter implements Converter<String, Date>{
    @Override
    public Date convert(String source) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        try {
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Date changing failed.");
        }
    }
}
