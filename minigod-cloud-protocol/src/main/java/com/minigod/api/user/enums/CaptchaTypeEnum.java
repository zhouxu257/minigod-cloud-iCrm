package com.minigod.api.user.enums;

/**
 * 短信验证结果
 */

public enum CaptchaTypeEnum {

	success("验证码成功", 0), error("验证码错误", 1), countout("超过次数", 2), isUsed("已经被使用", 3);

	private String typeName;
	private Integer typeValue;

	private CaptchaTypeEnum(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static String getTypeName(Integer index) {
		for (CaptchaTypeEnum typeEnum : CaptchaTypeEnum.values()) {
			if (typeEnum.getTypeValue().equals(index)) {
				return typeEnum.typeName;
			}
		}
		return null;
	}

	public static Integer getTypeValue(Integer index) {
		for (CaptchaTypeEnum typeEnum : CaptchaTypeEnum.values()) {
			if (typeEnum.getTypeValue().equals(index)) {
				return typeEnum.getTypeValue();
			}
		}
		return null;
	}
}
