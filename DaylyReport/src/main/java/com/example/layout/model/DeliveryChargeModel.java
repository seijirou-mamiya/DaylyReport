package com.example.layout.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.layout.table.AreaRateTable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 料金表クラス
 */
@Data
@AllArgsConstructor
@Component
public class DeliveryChargeModel{

	/**
	 * 料金表の取得
	 * @return 料金表
	 */
	public List<AreaRateTable> getAreaRateTable(){

		List<AreaRateTable> areaList = new ArrayList<AreaRateTable>();
		areaList.add(new AreaRateTable(0,"九州", 990, "豪雨災害により到着が遅れる地域があります。"));
		areaList.add(new AreaRateTable(1,"四国", 1100, ""));
		areaList.add(new AreaRateTable(2,"近畿", 1250, ""));
		
		return areaList;
	}
}