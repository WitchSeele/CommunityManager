package com.mapper.rentalManagement.Customer;

import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CustomerDao {
    @Insert({"INSERT INTO customer(c_id,c_name,c_age,c_occupation,c_contect,c_requirementType,c_requirementSize,c_prepaidAmount,c_address,c_use)" +
            "VALUES(#{c_id},#{c_name},#{c_age},#{c_occupation},#{c_contect},#{c_requirementType},#{c_requirementSize},#{c_prepaidAmount},#{c_address},#{c_use})"})

    int insertC(CustomerEntity customerEntity);

    @Delete({"DELETE FROM customer WHERE c_id=#{c_id,jdbcType=INTEGER}"})

    int deleteCById(@Param("c_id") int c_id);

    @Update({"UPDATE customer SET c_name=#{c_name},c_age=#{c_age},c_occupation=#{c_occupation}" +
            ",c_contect=#{c_contect},c_requirementType=#{c_requirementType},c_requirementSize=#{c_requirementSize},c_prepaidAmount=#{c_prepaidAmount},c_address=#{c_address},c_use=#{c_use} where c_id=#{c_id}"})
    int updateC(CustomerEntity customerEntity);

    @Select("SELECT * FROM customer")
    List<CustomerEntity> CList();

    @Select("select * from customer where c_id = #{c_id}")
    CustomerEntity selectByID(@Param("c_id")int c_id);

    @Select("select * from customer where c_name= #{c_name}")
    List<CustomerEntity> selectByName(String c_name);
}
