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

public class TUserToBroker extends AbstractTable {

	static {
		init();
	}

	private TUserToBroker(){
		super.tableName = "user_to_broker";
	}

	private TUserToBroker(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserToBroker getInstance() {
		return new TUserToBroker();
	}

	public static final TUserToBroker getInstance(String aliasName) {
		return new TUserToBroker(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("cellPhone", "cell_phone");
		allFieldMap.put("brokerType", "broker_type");
		allFieldMap.put("brokerName", "broker_name");
		allFieldMap.put("isBinding", "is_binding");
		allFieldMap.put("openAccountTime", "open_account_time");
		allFieldMap.put("openAccountCount", "open_account_count");
		allFieldMap.put("bindingTime", "binding_time");
		allFieldMap.put("bindingCount", "binding_count");
		allFieldMap.put("transactionTime", "transaction_time");
		allFieldMap.put("transactionCount", "transaction_count");
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
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 犇犇号 | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","犇犇号");

	/**
	 * 手机号码 | varchar(50)
	 */
	public final TableField<String> cellPhone = new TableFieldImpl<String>(this,"cell_phone","cellPhone","手机号码");

	/**
	 * 券商类型 | int(2)
	 */
	public final TableField<Integer> brokerType = new TableFieldImpl<Integer>(this,"broker_type","brokerType","券商类型");

	/**
	 * 券商名称 | varchar(100)
	 */
	public final TableField<String> brokerName = new TableFieldImpl<String>(this,"broker_name","brokerName","券商名称");

	/**
	 * 是否绑定(1:已绑定 0:未绑定 ) | tinyint(1)
	 */
	public final TableField<Boolean> isBinding = new TableFieldImpl<Boolean>(this,"is_binding","isBinding","是否绑定(1:已绑定 0:未绑定 )");

	/**
	 * 开户时间，最后一次点击开户按钮时间 | datetime
	 */
	public final DateTableField<Date> openAccountTime = new DateTableFieldImpl<Date>(this,"open_account_time","openAccountTime","开户时间，最后一次点击开户按钮时间");

	/**
	 * 开户次数，点击开户按钮次数 | int(10)
	 */
	public final TableField<Integer> openAccountCount = new TableFieldImpl<Integer>(this,"open_account_count","openAccountCount","开户次数，点击开户按钮次数");

	/**
	 * 绑定时间，最后一次点击绑定按钮时间 | datetime
	 */
	public final DateTableField<Date> bindingTime = new DateTableFieldImpl<Date>(this,"binding_time","bindingTime","绑定时间，最后一次点击绑定按钮时间");

	/**
	 * 绑定次数，点击绑定按钮次数 | int(10)
	 */
	public final TableField<Integer> bindingCount = new TableFieldImpl<Integer>(this,"binding_count","bindingCount","绑定次数，点击绑定按钮次数");

	/**
	 * 交易时间，最后一次点击时间(绑定后统计) | datetime
	 */
	public final DateTableField<Date> transactionTime = new DateTableFieldImpl<Date>(this,"transaction_time","transactionTime","交易时间，最后一次点击时间(绑定后统计)");

	/**
	 * 交易次数,访问交易table次数 | int(10)
	 */
	public final TableField<Integer> transactionCount = new TableFieldImpl<Integer>(this,"transaction_count","transactionCount","交易次数,访问交易table次数");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,cellPhone,brokerType,brokerName,isBinding,openAccountTime,openAccountCount,bindingTime,bindingCount,transactionTime,transactionCount};

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
		return "TUserToBroker[table=user_to_broker]";
	}
}
