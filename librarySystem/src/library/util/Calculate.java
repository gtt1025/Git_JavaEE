package library.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate {
	// 生成图书编号，此编号由书类型id，书id，当前编号是此书的第几册组成
	public String createBarcode(Integer typeId, Integer bookId, Integer bookNo) {
		String barcode = "";
		// 判断位数，生成001，010这样的字符串
		if (typeId < 10) {
			barcode = barcode + "00" + typeId.toString();
		} else if (typeId < 100) {
			barcode = barcode + "0" + typeId.toString();
		} else {
			barcode = barcode + typeId.toString();
		}

		if (bookId < 10) {
			barcode = barcode + "00" + bookId.toString();
		} else if (bookId < 100) {
			barcode = barcode + "0" + bookId.toString();
		} else {
			barcode = barcode + bookId.toString();
		}

		if (bookNo < 10) {
			barcode = barcode + "00" + bookNo.toString();
		} else if (bookNo < 100) {
			barcode = barcode + "0" + bookNo.toString();
		} else {
			barcode = barcode + bookNo.toString();
		}

		return barcode;
	}

	// 用当前时间的年月日小时分秒以及读者的ID号生成读者借书证号
	public String createReaderIdentiCode(Integer readerNo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		String identiCode = sdf.format(new Date()).toString();
		if (readerNo < 10) {
			identiCode = identiCode + "00" + readerNo.toString();
		} else if (readerNo < 100) {
			identiCode = identiCode + "0" + readerNo.toString();
		} else {
			identiCode = identiCode + readerNo.toString();
		}
		return identiCode;
	}

	// 随机密码
	public String randomPassword(Integer length) {
		String pwd = "";
		// 生成位数
		for (int i = 0; i < length; i++) {
			// 随机大小写字母
			if ((int) 10 * Math.random() + 1 > 5) {
				// 随机大写
				int a = 97 + (int) (26 * Math.random());
				pwd = pwd + (char) a;
			} else {
				// 随机小写
				int a = 65 + (int) (26 * Math.random());
				pwd = pwd + (char) a;
			}
		}
		return pwd;
	}

	// 使用日期检索图书时，比较时间先后
	public int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return -1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
