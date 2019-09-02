package com.springboot.demo.api.tool;

public enum AuthToolException {
    AU_NO_READ_PERMISSION, // 没有权限，不可见
    AU_NO_OPERATION_PERMISSION, // 没有操作权限
    AU_NO_OUT_OPERATION_PERMISSION, // 没有外部操作权限
    AU_INVALID_ANNOTATION, // 无效注解
    AU_PERMISSION_CHECK_PARAM_ERROR // 权限验证出错
}
