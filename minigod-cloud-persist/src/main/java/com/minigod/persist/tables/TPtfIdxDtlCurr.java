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

public class TPtfIdxDtlCurr extends AbstractTable {

	static {
		init();
	}

	private TPtfIdxDtlCurr(){
		super.tableName = "ptf_idx_dtl_curr";
	}

	private TPtfIdxDtlCurr(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPtfIdxDtlCurr getInstance() {
		return new TPtfIdxDtlCurr();
	}

	public static final TPtfIdxDtlCurr getInstance(String aliasName) {
		return new TPtfIdxDtlCurr(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("ptfIdxDtlId", "ptf_idx_dtl_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("sortNo", "sort_no");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("hldPrc", "hld_prc");
		allFieldMap.put("hldBeginTime", "hld_begin_time");
		allFieldMap.put("balance", "balance");
		allFieldMap.put("price", "price");
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
	 * 组合拐点明细表id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ptf_idx_dtl_id","ptfIdxDtlId","组合拐点明细表id");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","组合拐点明细表id");

	public final TableField<Integer> ptfIdxDtlId = new TableFieldImpl<Integer>(this,"ptf_idx_dtl_id","ptfIdxDtlId","组合拐点明细表id");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 * 排序编号。用于前端展示 | int(11)
	 */
	public final TableField<Integer> sortNo = new TableFieldImpl<Integer>(this,"sort_no","sortNo","排序编号。用于前端展示");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","");

	/**
	 *  | decimal(10,4)
	 */
	public final TableField<Double> hldPrc = new TableFieldImpl<Double>(this,"hld_prc","hldPrc","");

	/**
	 * 开始持仓时间 | datetime
	 */
	public final DateTableField<Date> hldBeginTime = new DateTableFieldImpl<Date>(this,"hld_begin_time","hldBeginTime","开始持仓时间");

	/**
	 * 资产余额 | decimal(16,4)
	 */
	public final TableField<Double> balance = new TableFieldImpl<Double>(this,"balance","balance","资产余额");

	/**
	 * 资产价格 | decimal(10,4)
	 */
	public final TableField<Double> price = new TableFieldImpl<Double>(this,"price","price","资产价格");

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

	private final TableField<?>[] allFields = new TableField<?>[] {ptfIdxDtlId,ptfId,sortNo,assetId,hldPrc,hldBeginTime,balance,price,createTime,updateTime,lockVersion};

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
		return "TPtfIdxDtlCurr[table=ptf_idx_dtl_curr]";
	}
}
