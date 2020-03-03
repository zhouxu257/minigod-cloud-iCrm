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

public class TUserCertInvalid extends AbstractTable {

	static {
		init();
	}

	private TUserCertInvalid(){
		super.tableName = "user_cert_invalid";
	}

	private TUserCertInvalid(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserCertInvalid getInstance() {
		return new TUserCertInvalid();
	}

	public static final TUserCertInvalid getInstance(String aliasName) {
		return new TUserCertInvalid(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("certId", "cert_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("certType", "cert_type");
		allFieldMap.put("certCode", "cert_code");
		allFieldMap.put("isValid", "is_valid");
		allFieldMap.put("isLogin", "is_login");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 登录方式ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"cert_id","certId","登录方式ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","登录方式ID");

	public final TableField<Integer> certId = new TableFieldImpl<Integer>(this,"cert_id","certId","登录方式ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid) | tinyint(4)
	 */
	public final TableField<Integer> certType = new TableFieldImpl<Integer>(this,"cert_type","certType","凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid)");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> certCode = new TableFieldImpl<String>(this,"cert_code","certCode","");

	/**
	 * 是否已经验证(针对手机号和邮件，0未验证，1已验证) | tinyint(1)
	 */
	public final TableField<Boolean> isValid = new TableFieldImpl<Boolean>(this,"is_valid","isValid","是否已经验证(针对手机号和邮件，0未验证，1已验证)");

	/**
	 * 能否用于登录(1-能，2-不能) | tinyint(1)
	 */
	public final TableField<Boolean> isLogin = new TableFieldImpl<Boolean>(this,"is_login","isLogin","能否用于登录(1-能，2-不能)");

	/**
	 * 记录状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间(默认1有效，0无效) | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间(默认1有效，0无效)");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {certId,userId,certType,certCode,isValid,isLogin,isStatus,createTime,updateTime,lockVersion};

	public TableField<?>[] getAllFields() {
		return allFields;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getPK() {
		return pk;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getLockVersion() {
		return lock;
	}

	public final boolean isAutoGeneratedPK() {
		return false;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TUserCertInvalid[table=user_cert_invalid]";
	}
}
