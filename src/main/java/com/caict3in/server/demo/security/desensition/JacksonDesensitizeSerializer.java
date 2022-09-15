package com.caict3in.server.demo.security.desensition;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class JacksonDesensitizeSerializer extends JsonSerializer<String> implements ContextualSerializer{

    private JacksonDesensitionType type;

    private String match;

    private String target;

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)throws IOException {
        if (type!=null){
            try {
                if (StrUtil.isBlank(match)||StrUtil.isBlank(target)){
                    jsonGenerator.writeString(JacksonDesensitizationUtil.desensitization(value, type));
                }else {
                    jsonGenerator.writeString (JacksonDesensitizationUtil.doDesensitization(value,match,target));
                }
            } catch (Exception e) {
                log.warn("JacksonDesensitize has no field：[{}]",  type.type);
            }
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty)
            throws JsonMappingException {
        if (beanProperty != null) {
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                JacksonDesensitization desensitization = beanProperty.getAnnotation(JacksonDesensitization.class);
                if (desensitization != null) {
                    return new JacksonDesensitizeSerializer(desensitization.type(),desensitization.match(),desensitization.target());
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }
}
