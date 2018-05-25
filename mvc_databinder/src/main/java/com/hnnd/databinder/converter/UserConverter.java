package com.hnnd.databinder.converter;

import com.hnnd.databinder.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 用户自定义的类型转化器
 * Created by Administrator on 2018/4/16.
 */
@Component
public class UserConverter implements Converter<String,UserDto> {
    @Override
    public UserDto convert(String s) {
        if(StringUtils.isEmpty(s)) {
            return null;
        }
        String [] vals = s.split("-");
        if(vals == null || vals.length!=2) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUserName(vals[0]);
        userDto.setPassword(vals[1]);
        return userDto;
    }
}
