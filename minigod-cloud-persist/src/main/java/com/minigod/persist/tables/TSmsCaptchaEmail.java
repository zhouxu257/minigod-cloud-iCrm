package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.minigod.db4j.table.DateTableField;
import com.minigod.db4j.table.DateTableFieldImpl;

public class TSmsCaptchaEmail extends AbstractTable {

	static {
		init();
	}

	private TSmsCaptchaEmail(){
		super.tableName = "sms_captcha_email";
	}

	private TSmsCaptchaEmail(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSmsCaptchaEmail getInstance() {
		return new TSmsCaptchaEmail();
	}

	public static final TSmsCaptchaEmail getInstance(String aliasName) {
		return new TSmsCaptchaEmail(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("captchaId", "captcha_id");
		allFieldMap.put("email", "email");
		allFieldMap.put("userid", "userid");
		allFieldMap.put("captcha", "captcha");
		allFieldMap.put("expiresTime", "expires_time");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("isChecked", "is_checked");
		allFieldMap.put("isUsed", "is_used");
		allFieldMap.put("validateCount", "validate_count");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 验证码id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"captcha_id","captchaId","验证码id");
	public final TableField<Integer> captchaId = new TableFieldImpl<Integer>(this,"captcha_id","captchaId","验证码id");

	/**
	 * 邮箱地址 | char(50)
	 */
	public final TableField<String> email = new TableFieldImpl<String>(this,"email","email","邮箱地址");

	/**
	 * 用户id | int(10)
	 */
	public final TableField<Integer> userid = new TableFieldImpl<Integer>(this,"userid","userid","用户id");

	/**
	 * 验证码，16位 | char(100)
	 */
	public final TableField<String> captcha = new TableFieldImpl<String>(this,"captcha","captcha","验证码，16位");

	/**
	 * 验证码失效时间 | datetime
	 */
	public final DateTableField<Date> expiresTime = new DateTableFieldImpl<Date>(this,"expires_time","expiresTime","验证码失效时间");

	/**
	 * 验证码发送时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","验证码发送时间");

	/**
	 * 验证码修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","验证码修改时间");

	/**
	 * 是否验证过 | tinyint(1)
	 */
	public final TableField<Boolean> isChecked = new TableFieldImpl<Boolean>(this,"is_checked","isChecked","是否验证过");

	/**
	 * 是否使用过 | tinyint(1)
	 */
	public final TableField<Boolean> isUsed = new TableFieldImpl<Boolean>(this,"is_used","isUsed","是否使用过");

	/**
	 * 验证错误次数 | tinyint(4)
	 */
	public final TableField<Integer> validateCount = new TableFieldImpl<Integer>(this,"validate_count","validateCount","验证错误次数");

	private final TableField<?>[] allFields = new TableField<?>[] {captchaId,email,userid,captcha,expiresTime,createTime,updateTime,isChecked,isUsed,validateCount};

	public TableField<?>[] getAllFields() {
		return allFields;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getPK() {
		return pk;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getLockVersion() {
		return null;
	}

	public final boolean isAutoGeneratedPK() {
		return true;
	}

	public final boolean isLockVersion() {
		return false;
	}

	public String toString() {
		return "TSmsCaptchaEmail[table=sms_captcha_email]";
	}
}
