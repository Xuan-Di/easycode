package com.wzxlq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Package: com.wzxlq.entity
 * @ClassName: Memory
 * @Author: 王照轩
 * @CreateTime: 2021/3/17 10:36
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memory {
    List<Double> edenList;
    List<Double> oldList;
}
