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

public class TGrmServer extends AbstractTable {

	static {
		init();
	}

	private TGrmServer(){
		super.tableName = "grm_server";
	}

	private TGrmServer(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmServer getInstance() {
		return new TGrmServer();
	}

	public static final TGrmServer getInstance(String aliasName) {
		return new TGrmServer(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("serverId", "server_id");
		allFieldMap.put("serverName", "server_name");
		allFieldMap.put("serverGroup", "server_group");
		allFieldMap.put("serverIp", "server_ip");
		allFieldMap.put("serverPort", "server_port");
		allFieldMap.put("serverState", "server_state");
		allFieldMap.put("listDate", "list_date");
		allFieldMap.put("delistDate", "delist_date");
		allFieldMap.put("serverCode", "server_code");
		allFieldMap.put("serverType", "server_type");
		allFieldMap.put("entrustWay", "entrust_way");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"server_id","serverId","");
	public final TableField<Integer> serverId = new TableFieldImpl<Integer>(this,"server_id","serverId","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> serverName = new TableFieldImpl<String>(this,"server_name","serverName","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> serverGroup = new TableFieldImpl<Integer>(this,"server_group","serverGroup","");

	/**
	 *  | varchar(16)
	 */
	public final TableField<String> serverIp = new TableFieldImpl<String>(this,"server_ip","serverIp","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> serverPort = new TableFieldImpl<Integer>(this,"server_port","serverPort","");

	/**
	 *  | smallint(6)
	 */
	public final TableField<Integer> serverState = new TableFieldImpl<Integer>(this,"server_state","serverState","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> listDate = new DateTableFieldImpl<Date>(this,"list_date","listDate","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> delistDate = new DateTableFieldImpl<Date>(this,"delist_date","delistDate","");

	/**
	 *  | varchar(64)
	 */
	public final TableField<String> serverCode = new TableFieldImpl<String>(this,"server_code","serverCode","");

	/**
	 *  | smallint(6)
	 */
	public final TableField<Integer> serverType = new TableFieldImpl<Integer>(this,"server_type","serverType","");

	/**
	 *  | varchar(8)
	 */
	public final TableField<String> entrustWay = new TableFieldImpl<String>(this,"entrust_way","entrustWay","");

	private final TableField<?>[] allFields = new TableField<?>[] {serverId,serverName,serverGroup,serverIp,serverPort,serverState,listDate,delistDate,serverCode,serverType,entrustWay};

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
		return "TGrmServer[table=grm_server]";
	}
}
