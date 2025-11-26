package com.mbridge.msdk.newreward.function.command.retention;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AutoNewProcess {
    public static void bind(Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (((AutoNew) field.getAnnotation(AutoNew.class)) != null) {
                field.setAccessible(true);
                try {
                    field.set(obj, field.getType().getConstructor((Class[]) null).newInstance((Object[]) null));
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                } catch (InstantiationException e6) {
                    e6.printStackTrace();
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                } catch (InvocationTargetException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }
}
