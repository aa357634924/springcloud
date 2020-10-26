package com.rj.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 12:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestInfo {
    private Integer id;
    private String username;
    private Date operTime;
}
