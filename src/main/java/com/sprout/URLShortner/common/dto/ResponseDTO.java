package com.sprout.URLShortner.common.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private int StatusCode;
    private String StatusDescription;
    private String message;
}
