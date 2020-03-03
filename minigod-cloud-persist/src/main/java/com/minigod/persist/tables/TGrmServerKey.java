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

public class TGrmServerKey extends AbstractTable {

	static {
		init();
	}

	private TGrmServerKey(){
		super.tableName = "grm_server_key";
	}

	private TGrmServerKey(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmServerKey getInstance() {
		return new TGrmServerKey();
	}

	public static final TGrmServerKey getInstance(String aliasName) {
		return new TGrmServerKey(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("serverId", "server_id");
		allFieldMap.put("aesKey", "aes_key");
		allFieldMap.put("authDate", "auth_date");
		allFieldMap.put("authFunctions", "auth_functions");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("aesIv", "aes_iv");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"id","id","");
	public final TableField<Integer> id = new TableFieldImpl<Integer>(this,"id","id","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> serverId = new TableFieldImpl<Integer>(this,"server_id","serverId","");

	/**
	 *  | varchar(128)
	 */
	public final TableField<String> aesKey = new TableFieldImpl<String>(this,"aes_key","aesKey","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> authDate = new DateTableFieldImpl<Date>(this,"auth_date","authDate","");

	/**
	 *  | varchar(1024)
	 */
	public final TableField<String> authFunctions = new TableFieldImpl<String>(this,"auth_functions","authFunctions","");

	/**
	 *  | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","");

	/**
	 *  | varchar(128)
	 */
	public final TableField<String> aesIv = new TableFieldImpl<String>(this,"aes_iv","aesIv","");

	private final TableField<?>[] allFields = new TableField<?>[] {id,serverId,aesKey,authDate,authFunctions,remark,aesIv};

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
		return "TGrmServerKey[table=grm_server_key]";
	}
}
