package com.TaskManagement.repository;

import com.TaskManagement.model.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
    //  @Query(value = "SELECT * FROM folder inner join files on folder.id = files.folderId",nativeQuery = true)
}
