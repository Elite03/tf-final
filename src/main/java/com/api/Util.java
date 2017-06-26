package com.api;

import java.time.Instant;
import java.util.Date;

public class Util {

	public static Date now() {
		return Date.from(Instant.now());
	}
}
