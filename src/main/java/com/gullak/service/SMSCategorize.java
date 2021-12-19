package com.gullak.service;

import java.util.List;

import com.gullak.domain.SMS;
import com.gullak.domain.Summary;

public interface SMSCategorize {
	public Summary categorize(List<SMS> sms);
}
