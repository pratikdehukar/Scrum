package com.ScrumTool.BacklogItems;

public class BacklogItemDto {
	
	private Long backlogItemId;
    private String backlogName;
    private long backlogTypeId;

    public BacklogItemDto(Long backlogItemId, String backlogName, long backlogTypeId) {
        this.backlogItemId = backlogItemId;
        this.backlogName = backlogName;
        this.backlogTypeId = backlogTypeId;
    }

    // Getters and setters

    public Long getBacklogItemId() {
        return backlogItemId;
    }

    public void setBacklogItemId(Long backlogItemId) {
        this.backlogItemId = backlogItemId;
    }

    public String getBacklogName() {
        return backlogName;
    }

    public void setBacklogName(String backlogName) {
        this.backlogName = backlogName;
    }

    public long getBacklogTypeId() {
        return backlogTypeId;
    }

    public void setBacklogTypeName(long backlogTypeId) {
        this.backlogTypeId = backlogTypeId;
    }
}

