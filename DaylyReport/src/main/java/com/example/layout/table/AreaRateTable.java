package com.example.layout.table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 料金表クラス
 */
@Data
@AllArgsConstructor
public class AreaRateTable{
	int		id;		// 地域ID(例：1)
	String	name;	// 地域名(例：九州)
	int		rate;	// 料金(例：990)
	String	note;	// 備考(例：豪雨災害により到着が遅れる地域があります。)
}

