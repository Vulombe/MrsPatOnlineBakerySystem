/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.time.LocalDate;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author StuartLittles
 */
public interface ReportingService {
    public PDDocument getReport(LocalDate date1, LocalDate date2);
}
