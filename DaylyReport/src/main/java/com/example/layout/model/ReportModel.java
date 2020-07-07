package com.example.layout.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.layout.table.AreaRateTable;
import com.example.layout.table.ReportTable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 日報クラス
 */
@Data
@AllArgsConstructor
@Component
public class ReportModel{

	List<ReportTable> reportList;

	public ReportModel() {
		this.reportList = new ArrayList<ReportTable>();
		
		reportList.add(new ReportTable(1,"芳本 佑多", "2020/07/03", "単体試験仕様書作成中。期限＝今週中。オンスケジュール"));
		reportList.add(new ReportTable(2,"津山 彩夏", "2020/07/03", "導入教育受講中。本日はER図からDDLを自動生成する方法を学び…"));
		reportList.add(new ReportTable(3,"日本 一", "2020/07/03",   "間違って結合試験用データを単体試験環境へリリースしてしまい…"));
		reportList.add(new ReportTable(4,"伊勢崎 清次郎", "2020/07/03", "外部連携機能設計。今月中に詳細設計完了予定。機能設計中。"));
		reportList.add(new ReportTable(5,"細越 かりな", "2020/07/03", "結合試験データ作成中。全156ケース中76ケースまで作成済。オン…"));
		reportList.add(new ReportTable(6,"乙幡 茉奈実", "2020/07/03", "今日はデータベースオブジェクトを使って自動的にSQLが生成され…"));
		reportList.add(new ReportTable(7,"関 卓", "2020/07/03", "画面仕様のレビュー実施中。全34画面中24画面完了。2日程度の前…"));
		reportList.add(new ReportTable(8,"今井田 晃一朗", "2020/07/03", "Swaggerを用いてREST APIのドキュメントとテストを自動化する試…"));
		reportList.add(new ReportTable(9,"神原 宇美", "2020/07/03", "サーバーのrootでroot権限でdeleteしてしまい松井さんに怒られて…"));
		reportList.add(new ReportTable(10,"グエン・ホアン・ル・トゥイ・リン", "2020/07/03", "山浦顧問から挨拶が出来ていないと注意されました。明日からは…"));
	}
	
	public void addReport(ReportTable report) {
		reportList.add(report);
	}
	
	/**
	 * 日報リストの取得
	 * @return 日報リスト
	 */
	public List<ReportTable> getReportTable(){

		
		return reportList;
	}
}