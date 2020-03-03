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

public class TTrdExchange extends AbstractTable {

	static {
		init();
	}

	private TTrdExchange(){
		super.tableName = "trd_exchange";
	}

	private TTrdExchange(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TTrdExchange getInstance() {
		return new TTrdExchange();
	}

	public static final TTrdExchange getInstance(String aliasName) {
		return new TTrdExchange(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("realName", "realName");
		allFieldMap.put("phoneNo", "phoneNo");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("fundAccount", "fund_account");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("exchangeAmount", "exchange_amount");
		allFieldMap.put("exchangeStatus", "exchange_status");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("STATUS", "STATUS");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("assetId", "asset_id");
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
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","主键");

	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 用户id | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 用户真实姓名 | varchar(20)
	 */
	public final TableField<String> realName = new TableFieldImpl<String>(this,"realName","realName","用户真实姓名");

	/**
	 * 手机号 | varchar(20)
	 */
	public final TableField<String> phoneNo = new TableFieldImpl<String>(this,"phoneNo","phoneNo","手机号");

	/**
	 * 交易号 | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","交易号");

	/**
	 * 资金帐号 | varchar(20)
	 */
	public final TableField<String> fundAccount = new TableFieldImpl<String>(this,"fund_account","fundAccount","资金帐号");

	/**
	 * 兑换类型(1-港币兑换美元 2-美元兑换港币) | tinyint(4)
	 */
	public final TableField<Integer> exchangeType = new TableFieldImpl<Integer>(this,"exchange_type","exchangeType","兑换类型(1-港币兑换美元 2-美元兑换港币)");

	/**
	 * 兑换金额 | int(20)
	 */
	public final TableField<Integer> exchangeAmount = new TableFieldImpl<Integer>(this,"exchange_amount","exchangeAmount","兑换金额");

	/**
	 * 兑换状态（1-已提交 2-已受理 3-已退回 4-已完成） | tinyint(4)
	 */
	public final TableField<Integer> exchangeStatus = new TableFieldImpl<Integer>(this,"exchange_status","exchangeStatus","兑换状态（1-已提交 2-已受理 3-已退回 4-已完成）");

	/**
	 * 退回原因 | varchar(100)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","退回原因");

	/**
	 * 记录状态 0有效 1失效 | tinyint(4)
	 */
	public final TableField<Integer> STATUS = new TableFieldImpl<Integer>(this,"STATUS","STATUS","记录状态 0有效 1失效");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	/**
	 * 资产ID | varchar(20)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","资产ID");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,realName,phoneNo,clientId,fundAccount,exchangeType,exchangeAmount,exchangeStatus,remark,STATUS,createTime,updateTime,lockVersion,assetId};

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
		return true;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TTrdExchange[table=trd_exchange]";
	}
}
