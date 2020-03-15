package org.github.tjgykhulj.model;

import lombok.Data;


@Data
public class BaseResponse<T> {
    private int code;
    private T result;

    private BaseResponse(int code, T result) {
        this.code = code;
        this.result = result;
    }

    public static <T> BaseResponse<T> success(T res) {
        return new BaseResponse<>(200, res);
    }

    public static <T> BaseResponse<T> fail() {
        return new BaseResponse<>(400, null);
    }
}
