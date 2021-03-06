package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.VerifyAuthCa;import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VerifyAuthCaMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(VerifyAuthCa record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(VerifyAuthCa record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    VerifyAuthCa selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(VerifyAuthCa record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(VerifyAuthCa record);

    VerifyAuthCa selectOneByIdCard(@Param("idCard") String idCard);

    VerifyAuthCa selectOneByIdCardP10(@Param("idCard") String idCard);

    List<VerifyAuthCa> selectByIdCardAndStatus(@Param("idCard") String idCard,@Param("status")Integer status);

    VerifyAuthCa selectOneByCertDn(@Param("certDn") String certDn);

    List<VerifyAuthCa>  selectByIdCardAndStatusLessThan(@Param("idCard")String idCard,@Param("maxStatus")Integer maxStatus);

    int deleteByIdCardAndStatusLessThan(@Param("idCard")String idCard,@Param("maxStatus")Integer maxStatus);

}