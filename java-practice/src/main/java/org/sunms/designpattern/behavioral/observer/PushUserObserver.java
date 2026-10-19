package org.sunms.designpattern.behavioral.observer;

/**
 * 스마트폰 앱 사용자입니다. 알림을 받으면 "푸시 알림"을 띄웁니다.
 *
 * <p><b>역할:</b> Concrete Observer (구체적인 구독자 ①)</p>
 */
public class PushUserObserver implements SubscriberObserver {

    /** 사용자 이름 */
    private final String userName;

    /**
     * 앱 사용자를 만듭니다.
     *
     * @param userName 사용자 이름
     */
    public PushUserObserver(String userName) {
        this.userName = userName;
    }

    /**
     * 앱 푸시 알림을 띄웁니다.
     *
     * @param channelName 영상을 올린 채널 이름
     * @param videoTitle  새 영상 제목
     */
    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("    → [앱 푸시] " + userName + "님, '" + channelName + "' 새 영상: " + videoTitle);
    }
}
