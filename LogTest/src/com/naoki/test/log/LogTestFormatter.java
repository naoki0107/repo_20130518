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
			buf.append("�ڍ׃��x���i���j���b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.FINER) {
			buf.append("�ڍ׃��x���i���j���b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.FINE) {
			buf.append("�ڍ׃��x���i���j���b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.CONFIG) {
			buf.append("�ݒ胁�b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.INFO) {
			buf.append("��񃁃b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.WARNING) {
			buf.append("�x�����b�Z�[�W: ");
		} else if (logRecord.getLevel() == Level.SEVERE) {
			buf.append("�d��ȏ�Q���b�Z�[�W: ");
		}
		buf.append(logRecord.getMessage());
		buf.append("\n");
		return buf.toString();
	}

}
