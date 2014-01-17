package com.naoki.test.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LogTestFormatter extends Formatter {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
	@Override
	public String format(LogRecord logRecord) {
		final StringBuffer buf = new StringBuffer();
		buf.append(dateFormat.format(new Date(logRecord.getMillis())));
		buf.append(" ");
		buf.append(logRecord.getLoggerName());
		buf.append("\n");
		if (logRecord.getLevel() == Level.FINEST) {
			buf.append("詳細レベル（高）メッセージ: ");
		} else if (logRecord.getLevel() == Level.FINER) {
			buf.append("詳細レベル（中）メッセージ: ");
		} else if (logRecord.getLevel() == Level.FINE) {
			buf.append("詳細レベル（小）メッセージ: ");
		} else if (logRecord.getLevel() == Level.CONFIG) {
			buf.append("設定メッセージ: ");
		} else if (logRecord.getLevel() == Level.INFO) {
			buf.append("情報メッセージ: ");
		} else if (logRecord.getLevel() == Level.WARNING) {
			buf.append("警告メッセージ: ");
		} else if (logRecord.getLevel() == Level.SEVERE) {
			buf.append("重大な障害メッセージ: ");
		}
		buf.append(logRecord.getMessage());
		buf.append("\n");
		return buf.toString();
	}

}
