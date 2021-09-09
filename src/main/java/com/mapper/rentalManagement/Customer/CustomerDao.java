package com.mapper.rentalManagement.Customer;

import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerDao {
//    @Insert({"INSERT INTO customer(id,rs_name,rs_rs,rs_type,rs_address,rs_content,rs_time)" +
//            "VALUES(#{id},#{rs_name},#{rs_rs},#{rs_type},#{rs_address},#{rs_content},#{rs_time})"})

    int insertC(CustomerEntity customerEntity);

//    @Delete({"DELETE FROM rent_sale WHERE id=#{id,jdbcType=INTEGER}"})

    int deleteCById(@Param("id") int id);

//    @Update({"UPDATE rent_sale SET rs_name=#{rs_name},rs_rs=#{rs_rs},rs_type=#{rs_type}" +
//            ",rs_address=#{rs_address},rs_content=#{rs_content},rs_time=#{rs_time} where id=#{id}"})
    int updateC(CustomerEntity customerEntity);

//    @Select("SELECT * FROM rent_sale")
    List<CustomerEntity> CList();
}
