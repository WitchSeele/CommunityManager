package com.mapper.rentalManagement.RentAndSale;

import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RSDao {
    @Insert({"INSERT INTO rent_sale(id,rs_name,rs_rs,rs_type,rs_address,rs_content,rs_time)" +
            "VALUES(#{id},#{rs_name},#{rs_rs},#{rs_type},#{rs_address},#{rs_content},#{rs_time})"})

    int insertRS(RentAndSaleEntity rentAndSaleEntity);

    @Delete({"DELETE FROM rent_sale WHERE id=#{id,jdbcType=INTEGER}"})

    int deleteRSById(@Param("id") int id);

    @Update({"UPDATE rent_sale SET rs_name=#{rs_name},rs_rs=#{rs_rs},rs_type=#{rs_type}" +
            ",rs_address=#{rs_address},rs_content=#{rs_content},rs_time=#{rs_time} where id=#{id}"})
    int updateRS(RentAndSaleEntity rentAndSaleEntity);
    @Select("SELECT * FROM rent_sale")
    List<RentAndSaleEntity> RSList();
}
