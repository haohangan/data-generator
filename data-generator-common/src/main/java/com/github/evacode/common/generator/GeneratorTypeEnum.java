package com.github.evacode.common.generator;

/**
 * 支持生成的数据类型分类
 */
public enum GeneratorTypeEnum {

    INT("integer"),//整数
    DECIMAL("decimal"), //浮点数
    BOOL("bool"), //布尔
    STR("string"), //字符类型
    OBJ("object"), //Object
    OTHER("other");//其他类型

    private final String type;


    GeneratorTypeEnum(String type) {
        this.type = type;
    }
}
