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

public class TAdUserActInfo extends AbstractTable {

	static {
		init();
	}

	private TAdUserActInfo(){
		super.tableName = "ad_user_act_info";
	}

	private TAdUserActInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TAdUserActInfo getInstance() {
		return new TAdUserActInfo();
	}

	public static final TAdUserActInfo getInstance(String aliasName) {
		return new TAdUserActInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("adUserActId", "ad_user_act_id");
		allFieldMap.put("adId", "ad_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("strA", "str_a");
		allFieldMap.put("strB", "str_b");
		allFieldMap.put("strC", "str_c");
		allFieldMap.put("strD", "str_d");
		allFieldMap.put("strE", "str_e");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("createTime", "create_time");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ad_user_act_id","adUserActId","");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","");

	public final TableField<Integer> adUserActId = new TableFieldImpl<Integer>(this,"ad_user_act_id","adUserActId","");

	/**
	 * 广告id | int(11)
	 */
	public final TableField<Integer> adId = new TableFieldImpl<Integer>(this,"ad_id","adId","广告id");

	/**
	 * 用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 组合id | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合id");

	/**
	 * 卡牌数量 | varchar(50)
	 */
	public final TableField<String> strA = new TableFieldImpl<String>(this,"str_a","strA","卡牌数量");

	/**
	 * 金币数量 | varchar(50)
	 */
	public final TableField<String> strB = new TableFieldImpl<String>(this,"str_b","strB","金币数量");

	/**
	 * 金额 | varchar(50)
	 */
	public final TableField<String> strC = new TableFieldImpl<String>(this,"str_c","strC","金额");

	/**
	 * 记录活动结果 | varchar(100)
	 */
	public final TableField<String> strD = new TableFieldImpl<String>(this,"str_d","strD","记录活动结果");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> strE = new TableFieldImpl<String>(this,"str_e","strE","");

	/**
	 * 乐观锁 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	private final TableField<?>[] allFields = new TableField<?>[] {adUserActId,adId,userId,ptfId,strA,strB,strC,strD,strE,lockVersion,updateTime,createTime};

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
		return "TAdUserActInfo[table=ad_user_act_info]";
	}
}
