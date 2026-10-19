package org.sunms.designpattern.behavioral.observer;

/**
 * 이메일 구독자입니다. 같은 알림을 받아도 "이메일 발송"으로 반응합니다.
 * (옵저버마다 반응 방식이 달라도 된다는 것을 보여주는 예시)
 *
 * <p><b>역할:</b> Concrete Observer (구체적인 구독자 ②)</p>
 */
public class EmailUserObserver implements SubscriberObserver {

    /** 알림을 받을 이메일 주소 */
    private final String email;

    /**
     * 이메일 구독자를 만듭니다.
     *
     * @param email 이메일 주소
     */
    public EmailUserObserver(String email) {
        this.email = email;
    }

    /**
     * 새 영상 소식을 이메일로 보냅니다.
     *
     * @param channelName 영상을 올린 채널 이름
     * @param videoTitle  새 영상 제목
     */
    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("    → [이메일] " + email + " 로 발송: [" + channelName + "] " + videoTitle);
    }
}
