package com.sky.service;

import com.sky.vo.TurnoverReportVO;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public interface ReportService {

    TurnoverReportVO getTurnoverStatistics(LocalDate begin,LocalDate end);

    void exportBussinessData(HttpServletResponse response);
}
