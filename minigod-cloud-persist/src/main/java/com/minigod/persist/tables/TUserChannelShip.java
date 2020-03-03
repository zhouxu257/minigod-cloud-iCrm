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

public class TUserChannelShip extends AbstractTable {

	static {
		init();
	}

	private TUserChannelShip(){
		super.tableName = "user_channel_ship";
	}

	private TUserChannelShip(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserChannelShip getInstance() {
		return new TUserChannelShip();
	}

	public static final TUserChannelShip getInstance(String aliasName) {
		return new TUserChannelShip(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("channelId", "channel_id");
		allFieldMap.put("type", "type");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("isStatus", "is_status");
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
	 *  | varchar(30)
	 */
	public final TableField<String> channelId = new TableFieldImpl<String>(this,"channel_id","channelId","");

	/**
	 * 1:玖富犇犇
，2:玖富股票 | tinyint(4)
	 */
	public final TableField<Integer> type = new TableFieldImpl<Integer>(this,"type","type","1:玖富犇犇，2:玖富股票");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","");

	/**
	 *  | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","");

	private final TableField<?>[] allFields = new TableField<?>[] {id,channelId,type,createTime,isStatus};

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
		return "TUserChannelShip[table=user_channel_ship]";
	}
}
