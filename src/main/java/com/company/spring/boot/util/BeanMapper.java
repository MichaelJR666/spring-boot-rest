/**
 * 
 */
package com.company.spring.boot.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author NevinChen
 *
 */
public class BeanMapper {

    private static Mapper mapper = new DozerBeanMapper();
    
    public static <T> T map(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }
    
    public static <T> List<T> mapList(Iterable<Object> sourceList, Class<T> destinationClass) {
        List<T> destionationList = new ArrayList<T>();
        sourceList.forEach(source -> destionationList.add(mapper.map(source, destinationClass)));
        return destionationList;
    }
    
    public static void map(Object source, Object destination) {
        mapper.map(source, destination);
    }
    
}
