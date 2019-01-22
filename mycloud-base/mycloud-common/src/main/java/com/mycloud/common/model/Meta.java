package com.mycloud.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    private String title;
    private String icon;
    private List<String> roles;
}
