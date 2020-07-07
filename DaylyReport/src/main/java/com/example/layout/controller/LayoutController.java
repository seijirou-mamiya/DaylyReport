package com.example.layout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.layout.config.FooterConfig;
import com.example.layout.config.LogoConfig;
import com.example.layout.form.AreaForm;
import com.example.layout.form.LoginForm;
import com.example.layout.form.ReportForm;
import com.example.layout.model.CatchCopyModel;
import com.example.layout.model.DeliveryChargeModel;
import com.example.layout.model.LogoModel;
import com.example.layout.model.ReportModel;
import com.example.layout.model.TitleModel;
import com.example.layout.model.TodaysWordModel;
import com.example.layout.table.ReportTable;

@Controller
public class LayoutController {

	@Autowired
	FooterConfig	user;

	@Autowired
	TodaysWordModel todaysWordModel;
	
	@Autowired
	DeliveryChargeModel deliveryChargeModel;

	@Autowired
	CatchCopyModel catchCopyModel;
	
	@Autowired
	FooterConfig footerConfig;

	@Autowired
	LogoModel logoModel;

	@Autowired
	TitleModel titleModel;
	
	@Autowired
	ReportModel reportModel;

	private String loginUserName;
	
	/**
	 * 地域選択画面エンドポイント
	 * @param model ビューへ渡すデータ
	 * @return 遷移先ビュー名称
	 */
	@RequestMapping(value="/areaSelect", method=RequestMethod.GET)
	String test(Model model) {

		// 共通処理
		this.commonProcess(model, "地域選択");

		// 料金表（プルダウンと表の表示で使っています）
		model.addAttribute("areaList", deliveryChargeModel.getAreaRateTable());
		
		return "/areaSelect";
	}
	
	/**
	 * 地域フォーム受信エンドポイント
	 * @param area ビューから渡された地域フォーム
	 * @param model ビューへ渡すデータ
	 * @return 遷移先ビュー名称
	 */
	@RequestMapping(value="/areaSelect", method=RequestMethod.POST)
	String areaSelect(AreaForm area, Model model) {

		// 共通処理
		this.commonProcess(model, "選択結果");

		// 選択された地域を設定
		model.addAttribute("message", area.getAreaName() + "が選択されました。");

		return "result";
	}

	/**
	 * 各メソッドの共通処理
	 * @param model ビューへ渡すデータ
	 * @param pageTitle ブラウザに表示されるタイトル
	 */
	// 本来は、こういった共通処理はinterceptやAOPなどの技術を使いますが、
	// 分かりやすいサンプルプログラムとして共通処理をメソッド呼び出しにしています。
	private void commonProcess(Model model, String pageTitle) {
		// タイトル取得
		String appTitle = titleModel.getTitle();
		
		// ヘッダの今日のひとことを設定
		String word = todaysWordModel.getTodaysWord();
		model.addAttribute("todaysWord", word);

		// フッタの設定
		model.addAttribute("jp", footerConfig.getJp());
		model.addAttribute("eng", footerConfig.getEng());

		// サイドバーの設定
		model.addAttribute("logoTitle", titleModel.getTitle());
		model.addAttribute("logoUrl", "logo/" + logoModel.getLogoUrl());
		model.addAttribute("catchcopy", catchCopyModel.getCatchCopy());
		model.addAttribute("loginUserName", "ログインユーザー　  "+this.loginUserName);
		
		// ブラウザのタブに表示されるタイトル設定
		model.addAttribute("title", appTitle +" | " + pageTitle);
	}
	
	@GetMapping("/login")
	public String loginGet(Model model, LoginForm form) {
		// 共通処理
		this.commonProcess(model, "ログイン");

		return "login";
	}

	@GetMapping("/")
	public String defaultIndex(Model model) {
		return "forward:login";
	}

	@GetMapping("/index")
	public String index(Model model) {
		return "forward:login";
	}

	@PostMapping("/login")
	public String loginPost(Model model, @Validated LoginForm form, BindingResult error) {

		String result;

        if(error.hasErrors()){
        	for( ObjectError e : error.getAllErrors()	 ) {
        		System.out.println("code=" + e.getCode());
        		System.out.println("defaultMessage=" + e.getDefaultMessage());
        		System.out.println("objectName=" + e.getObjectName());
        		System.out.println("arguments" + e.getArguments());
        	}
    		// 共通処理
    		this.commonProcess(model, "日報一覧");
    		return "login";
        }

		System.out.println("user=" + form.getLoginUserName());
		System.out.println("pass=" + form.getLoginPassWord());
        
		if ("usagi".equals(form.getLoginUserName())) {
			this.loginUserName = "山浦 九州男";
			model.addAttribute("reportList", reportModel.getReportList());		
			result = "report_list";
		}
		else if ("miyake".equals(form.getLoginUserName())){
			this.loginUserName = "宮家 結太";
			result = "create_report";
		}
		else {
			model.addAttribute("message","ユーザー名かパスワードが間違っています。");
			result = "login";
		}

		// 共通処理
		this.commonProcess(model, "日報一覧");

		return result;
	}
	
	@PostMapping("/create_report")
	public String createReport(Model model,ReportForm form) {
		// 共通処理
		this.commonProcess(model, "日報一覧");

		ReportTable report = new ReportTable(11, this.loginUserName, "2020/07/03", form.getNote());
		reportModel.addReport(report);
		
		return "send";
	}

	@GetMapping("/reportlist")
	public String reportList(Model model) {
		// 共通処理
		this.commonProcess(model, "日報一覧");

		model.addAttribute("reportList", reportModel.getReportList());		
		
		return "report_list";
	}
}
