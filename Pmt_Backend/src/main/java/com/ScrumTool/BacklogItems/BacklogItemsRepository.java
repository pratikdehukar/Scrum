package com.ScrumTool.BacklogItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BacklogItemsRepository extends JpaRepository<BacklogItems, Long> {

    // Custom query to fetch specific columns from BacklogItems table
    @Query("SELECT new com.ScrumTool.BacklogItems.BacklogItemDto(bi.backlogItemId, bi.backlogName, bi.backlogTypeId.backlogTypeId) " +
            "FROM BacklogItems bi")
    List<BacklogItemDto> findBacklogItemColumns();
}
