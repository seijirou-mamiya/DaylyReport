package com.example.layout.table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日報クラス
 */
@Data
@AllArgsConstructor
public class ReportTable{
	int		id;		// 日報ID(例：1)
	String	name;	// 報告者(例：みやけ)
	String	date;	// 登校日(例：2020/07/03)
	String	note;	// 内容(例：明日から結合テストだ。大変だと思った。)
}

