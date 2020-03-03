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

public class TCashBindBank extends AbstractTable {

	static {
		init();
	}

	private TCashBindBank(){
		super.tableName = "cash_bind_bank";
	}

	private TCashBindBank(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TCashBindBank getInstance() {
		return new TCashBindBank();
	}

	public static final TCashBindBank getInstance(String aliasName) {
		return new TCashBindBank(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("bindId", "bind_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("userName", "user_name");
		allFieldMap.put("cellPhone", "cell_phone");
		allFieldMap.put("idCardNo", "id_card_no");
		allFieldMap.put("bankCode", "bank_code");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("bankNo", "bank_no");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 主键 | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"bind_id","bindId","主键");
	public final TableField<Long> bindId = new TableFieldImpl<Long>(this,"bind_id","bindId","主键");

	/**
	 * 用户ID | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 持卡人姓名 | varchar(20)
	 */
	public final TableField<String> userName = new TableFieldImpl<String>(this,"user_name","userName","持卡人姓名");

	/**
	 * 手机号 | varchar(20)
	 */
	public final TableField<String> cellPhone = new TableFieldImpl<String>(this,"cell_phone","cellPhone","手机号");

	/**
	 * 身份证号 | varchar(20)
	 */
	public final TableField<String> idCardNo = new TableFieldImpl<String>(this,"id_card_no","idCardNo","身份证号");

	/**
	 * 银行卡代码 | varchar(20)
	 */
	public final TableField<String> bankCode = new TableFieldImpl<String>(this,"bank_code","bankCode","银行卡代码");

	/**
	 * 银行卡名称 | varchar(100)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","银行卡名称");

	/**
	 * 银行卡号 | varchar(50)
	 */
	public final TableField<String> bankNo = new TableFieldImpl<String>(this,"bank_no","bankNo","银行卡号");

	/**
	 * 绑定状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","绑定状态");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {bindId,userId,userName,cellPhone,idCardNo,bankCode,bankName,bankNo,isStatus,createTime,updateTime};

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
		return "TCashBindBank[table=cash_bind_bank]";
	}
}
