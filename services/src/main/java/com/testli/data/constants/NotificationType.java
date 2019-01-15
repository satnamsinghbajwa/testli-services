package com.testli.data.constants;

public enum NotificationType {

	EMAIL(0), PNS(1), SMS(2);

	private int notificationCode;

	private NotificationType(int notificationCode) {
		this.notificationCode = notificationCode;
	}

	public int getNotificationCode() {
		return this.notificationCode;
	}

	public static NotificationType getNotificationTypeByCode(int notificationCode) {
		for (NotificationType notificationType : NotificationType.values()) {
			if (notificationType.getNotificationCode() == notificationCode) {
				return notificationType;
			}
		}
		throw new IllegalArgumentException("illegal notification code : " + notificationCode);
	}

}
