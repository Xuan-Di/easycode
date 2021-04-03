package com.wzxlq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.wzxlq.entity
 * @ClassName: Event
 * @Author: 王照轩
 * @CreateTime: 2021/3/24 15:02
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    String debug;
    String warn;
    String error;
}
