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

public class TStkHisOrder extends AbstractTable {

	static {
		init();
	}

	private TStkHisOrder(){
		super.tableName = "stk_his_order";
	}

	private TStkHisOrder(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TStkHisOrder getInstance() {
		return new TStkHisOrder();
	}

	public static final TStkHisOrder getInstance(String aliasName) {
		return new TStkHisOrder(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("ordersno", "ordersno");
		allFieldMap.put("secuid", "secuid");
		allFieldMap.put("stkcode", "stkcode");
		allFieldMap.put("stkname", "stkname");
		allFieldMap.put("bsflag", "bsflag");
		allFieldMap.put("orderstatus", "orderstatus");
		allFieldMap.put("orderprice", "orderprice");
		allFieldMap.put("orderqty", "orderqty");
		allFieldMap.put("cancelqty", "cancelqty");
		allFieldMap.put("opertime", "opertime");
		allFieldMap.put("market", "market");
		allFieldMap.put("matchamt", "matchamt");
		allFieldMap.put("fundid", "fundid");
		allFieldMap.put("cancelflag", "cancelflag");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("inputid", "inputid");
		allFieldMap.put("orderdate", "orderdate");
		allFieldMap.put("orderid", "orderid");
		allFieldMap.put("poststr", "poststr");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | int(255)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ordersno","ordersno","");
	public final TableField<Integer> ordersno = new TableFieldImpl<Integer>(this,"ordersno","ordersno","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> secuid = new TableFieldImpl<String>(this,"secuid","secuid","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> stkcode = new TableFieldImpl<String>(this,"stkcode","stkcode","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> stkname = new TableFieldImpl<String>(this,"stkname","stkname","");

	/**
	 *  | varchar(10)
	 */
	public final TableField<String> bsflag = new TableFieldImpl<String>(this,"bsflag","bsflag","");

	/**
	 *  | varchar(10)
	 */
	public final TableField<String> orderstatus = new TableFieldImpl<String>(this,"orderstatus","orderstatus","");

	/**
	 *  | decimal(10,4)
	 */
	public final TableField<Double> orderprice = new TableFieldImpl<Double>(this,"orderprice","orderprice","");

	/**
	 *  | decimal(15,4)
	 */
	public final TableField<Double> orderqty = new TableFieldImpl<Double>(this,"orderqty","orderqty","");

	/**
	 *  | decimal(10,4)
	 */
	public final TableField<Double> cancelqty = new TableFieldImpl<Double>(this,"cancelqty","cancelqty","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> opertime = new TableFieldImpl<Integer>(this,"opertime","opertime","");

	/**
	 *  | varchar(1)
	 */
	public final TableField<String> market = new TableFieldImpl<String>(this,"market","market","");

	/**
	 *  | decimal(15,4)
	 */
	public final TableField<Double> matchamt = new TableFieldImpl<Double>(this,"matchamt","matchamt","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> fundid = new TableFieldImpl<String>(this,"fundid","fundid","");

	/**
	 *  | varchar(1)
	 */
	public final TableField<String> cancelflag = new TableFieldImpl<String>(this,"cancelflag","cancelflag","");

	/**
	 *  | date
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","");

	/**
	 *  | date
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> inputid = new TableFieldImpl<String>(this,"inputid","inputid","");

	/**
	 *  | date
	 */
	public final DateTableField<Date> orderdate = new DateTableFieldImpl<Date>(this,"orderdate","orderdate","");

	/**
	 *  | int(255)
	 */
	public final TableField<Integer> orderid = new TableFieldImpl<Integer>(this,"orderid","orderid","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> poststr = new TableFieldImpl<String>(this,"poststr","poststr","");

	private final TableField<?>[] allFields = new TableField<?>[] {ordersno,secuid,stkcode,stkname,bsflag,orderstatus,orderprice,orderqty,cancelqty,opertime,market,matchamt,fundid,cancelflag,createTime,updateTime,inputid,orderdate,orderid,poststr};

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
		return false;
	}

	public final boolean isLockVersion() {
		return false;
	}

	public String toString() {
		return "TStkHisOrder[table=stk_his_order]";
	}
}
