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

public class TGrmTrdStockJour extends AbstractTable {

	static {
		init();
	}

	private TGrmTrdStockJour(){
		super.tableName = "grm_trd_stock_jour";
	}

	private TGrmTrdStockJour(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmTrdStockJour getInstance() {
		return new TGrmTrdStockJour();
	}

	public static final TGrmTrdStockJour getInstance(String aliasName) {
		return new TGrmTrdStockJour(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("jourId", "jour_id");
		allFieldMap.put("currDate", "curr_date");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("fundAccount", "fund_account");
		allFieldMap.put("moneyType", "money_type");
		allFieldMap.put("businessFlag", "business_flag");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("stockCode", "stock_code");
		allFieldMap.put("market", "market");
		allFieldMap.put("occurAmount", "occur_amount");
		allFieldMap.put("postAmount", "post_amount");
		allFieldMap.put("extPositionStr", "ext_position_str");
		allFieldMap.put("extSerialNo", "ext_serial_no");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("initDate", "init_date");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"jour_id","jourId","");
	public final TableField<Long> jourId = new TableFieldImpl<Long>(this,"jour_id","jourId","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> currDate = new DateTableFieldImpl<Date>(this,"curr_date","currDate","");

	/**
	 *  | varchar(16)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> fundAccount = new TableFieldImpl<Integer>(this,"fund_account","fundAccount","");

	/**
	 *  | varchar(8)
	 */
	public final TableField<String> moneyType = new TableFieldImpl<String>(this,"money_type","moneyType","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> businessFlag = new TableFieldImpl<Integer>(this,"business_flag","businessFlag","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> stockCode = new TableFieldImpl<String>(this,"stock_code","stockCode","");

	/**
	 *  | varchar(8)
	 */
	public final TableField<String> market = new TableFieldImpl<String>(this,"market","market","");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> occurAmount = new TableFieldImpl<Long>(this,"occur_amount","occurAmount","");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> postAmount = new TableFieldImpl<Long>(this,"post_amount","postAmount","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> extPositionStr = new TableFieldImpl<String>(this,"ext_position_str","extPositionStr","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> extSerialNo = new TableFieldImpl<Integer>(this,"ext_serial_no","extSerialNo","");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","");

	/**
	 *  | date
	 */
	public final DateTableField<Date> initDate = new DateTableFieldImpl<Date>(this,"init_date","initDate","");

	private final TableField<?>[] allFields = new TableField<?>[] {jourId,currDate,clientId,fundAccount,moneyType,businessFlag,assetId,stockCode,market,occurAmount,postAmount,extPositionStr,extSerialNo,remark,initDate};

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
		return "TGrmTrdStockJour[table=grm_trd_stock_jour]";
	}
}
