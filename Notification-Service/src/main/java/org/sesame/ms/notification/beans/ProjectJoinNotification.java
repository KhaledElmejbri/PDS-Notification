package org.sesame.ms.notification.beans;

public class ProjectJoinNotification {

    private Long id;
    private String referencedProjectId;
    private String senderDisplayName;
    private String senderAvatarUrl;
    private String senderId;
    private String responseType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencedProjectId() {
        return referencedProjectId;
    }

    public void setReferencedProjectId(String referencedProjectId) {
        this.referencedProjectId = referencedProjectId;
    }

    public String getSenderDisplayName() {
        return senderDisplayName;
    }

    public void setSenderDisplayName(String senderDisplayName) {
        this.senderDisplayName = senderDisplayName;
    }

    public String getSenderAvatarUrl() {
        return senderAvatarUrl;
    }

    public void setSenderAvatarUrl(String senderAvatarUrl) {
        this.senderAvatarUrl = senderAvatarUrl;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
