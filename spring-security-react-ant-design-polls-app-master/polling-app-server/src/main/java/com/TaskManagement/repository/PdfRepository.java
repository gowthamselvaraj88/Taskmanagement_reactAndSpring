package com.TaskManagement.repository;

import com.TaskManagement.model.PdfContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfRepository extends JpaRepository<PdfContent, Long> {

}
