package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;

public class TFeatTask extends AbstractTable {

	static {
		init();
	}

	private TFeatTask(){
		super.tableName = "feat_task";
	}

	private TFeatTask(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFeatTask getInstance() {
		return new TFeatTask();
	}

	public static final TFeatTask getInstance(String aliasName) {
		return new TFeatTask(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("featTastId", "feat_tast_id");
		allFieldMap.put("featId", "feat_id");
		allFieldMap.put("taskName", "task_name");
		allFieldMap.put("targeValue", "targe_value");
		allFieldMap.put("reward", "reward");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"feat_tast_id","featTastId","");
	public final TableField<Integer> featTastId = new TableFieldImpl<Integer>(this,"feat_tast_id","featTastId","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> featId = new TableFieldImpl<Integer>(this,"feat_id","featId","");

	/**
	 * 任务名称 | varchar(20)
	 */
	public final TableField<String> taskName = new TableFieldImpl<String>(this,"task_name","taskName","任务名称");

	/**
	 * 目标值 | int(11)
	 */
	public final TableField<Integer> targeValue = new TableFieldImpl<Integer>(this,"targe_value","targeValue","目标值");

	/**
	 * 奖励 | int(11)
	 */
	public final TableField<Integer> reward = new TableFieldImpl<Integer>(this,"reward","reward","奖励");

	private final TableField<?>[] allFields = new TableField<?>[] {featTastId,featId,taskName,targeValue,reward};

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
		return "TFeatTask[table=feat_task]";
	}
}
