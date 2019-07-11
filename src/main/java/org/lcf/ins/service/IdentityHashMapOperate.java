package org.lcf.ins.service;

import java.util.ArrayList;
import java.util.IdentityHashMap;

public class IdentityHashMapOperate
{
    public static IdentityHashMap addValue(IdentityHashMap map, double distance, Object value)
    {
        if(map.get("sort") == null)//没有顺序控制key
        {
            map.put("sort", distance);//直接增加顺序控制key
            map.put(distance, value);
        }
        else
        {
              String sort = map.get("sort").toString();//取出顺序控制key
              sort+= "^"+distance;//需要控制顺序的key
              map.put("sort", sort);//回写到map
              map.put(distance, value);
        }

        return map;
    }

    public static ArrayList getValues(IdentityHashMap map)
    {
        String sort = map.get("sort").toString();
        ArrayList values = new ArrayList();

        if(sort != null)
        { 
            String[] sortKeys = sort.split("\\^");

            for(int i = 0; i < sortKeys.length; i++)
            {
                String key = sortKeys[i];
                Object value = map.get(key.intern());
                values.add(value);
            }
        }
        return values;
    }
}
