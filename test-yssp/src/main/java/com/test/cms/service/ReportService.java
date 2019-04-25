package com.test.cms.service;

import com.test.tools.util.QingYinResult;

public interface ReportService {
    QingYinResult findAllUser(Integer page, Integer rows);
}
