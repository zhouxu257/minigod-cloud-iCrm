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

public class TGameUserInfo extends AbstractTable {

	static {
		init();
	}

	private TGameUserInfo(){
		super.tableName = "game_user_info";
	}

	private TGameUserInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGameUserInfo getInstance() {
		return new TGameUserInfo();
	}

	public static final TGameUserInfo getInstance(String aliasName) {
		return new TGameUserInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("gameUserId", "game_user_id");
		allFieldMap.put("certType", "cert_type");
		allFieldMap.put("certCode", "cert_code");
		allFieldMap.put("nickName", "nick_name");
		allFieldMap.put("userIcon", "user_icon");
		allFieldMap.put("unionId", "union_id");
		allFieldMap.put("isSubscribe", "is_subscribe");
		allFieldMap.put("successNum", "success_num");
		allFieldMap.put("totalYield", "total_yield");
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
	 *  | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"game_user_id","gameUserId","");
	public final TableField<Integer> gameUserId = new TableFieldImpl<Integer>(this,"game_user_id","gameUserId","");

	/**
	 * 凭证类型(6-微信齐牛公众号openid) | tinyint(4)
	 */
	public final TableField<Integer> certType = new TableFieldImpl<Integer>(this,"cert_type","certType","凭证类型(6-微信齐牛公众号openid)");

	/**
	 * 凭证内容(微信openid等) | varchar(100)
	 */
	public final TableField<String> certCode = new TableFieldImpl<String>(this,"cert_code","certCode","凭证内容(微信openid等)");

	/**
	 * 昵称 | varchar(100)
	 */
	public final TableField<String> nickName = new TableFieldImpl<String>(this,"nick_name","nickName","昵称");

	/**
	 * 头像 | varchar(200)
	 */
	public final TableField<String> userIcon = new TableFieldImpl<String>(this,"user_icon","userIcon","头像");

	/**
	 * 微信union_id | varchar(100)
	 */
	public final TableField<String> unionId = new TableFieldImpl<String>(this,"union_id","unionId","微信union_id");

	/**
	 * 是否关注公众号 | tinyint(1)
	 */
	public final TableField<Boolean> isSubscribe = new TableFieldImpl<Boolean>(this,"is_subscribe","isSubscribe","是否关注公众号");

	/**
	 * 推荐成功次数(每次荐股盈亏为正加一) | int(11)
	 */
	public final TableField<Integer> successNum = new TableFieldImpl<Integer>(this,"success_num","successNum","推荐成功次数(每次荐股盈亏为正加一)");

	/**
	 * 累计收益率 | decimal(10,4)
	 */
	public final TableField<Double> totalYield = new TableFieldImpl<Double>(this,"total_yield","totalYield","累计收益率");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	private final TableField<?>[] allFields = new TableField<?>[] {gameUserId,certType,certCode,nickName,userIcon,unionId,isSubscribe,successNum,totalYield,createTime,updateTime};

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
		return "TGameUserInfo[table=game_user_info]";
	}
}
