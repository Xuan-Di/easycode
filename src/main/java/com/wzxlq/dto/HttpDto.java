package com.wzxlq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Package: com.wzxlq.dto
 * @ClassName: httpDto
 * @Author: 王照轩
 * @CreateTime: 2021/3/31 14:53
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpDto {
    private String interfaceName;
    private Integer threshold;
    private List<Double> useData;
}
