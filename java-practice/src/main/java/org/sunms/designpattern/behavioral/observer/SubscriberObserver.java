package org.sunms.designpattern.behavioral.observer;

/**
 * "구독자라면 알림을 받을 수 있는 {@link #update(String, String)} 메서드가 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Observer (알림을 받는 쪽의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainObserver#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>앱 푸시 사용자, 이메일 사용자 모두 이 규격을 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>채널({@link YoutubeChannelObserver})이 "구독자가 누구인지 몰라도" 알림을 보낼 수 있게 하기 위해서입니다.</p>
 * <pre>{@code
 * private final List<SubscriberObserver> subscribers;      // 종류가 달라도 한 목록에!
 * for (SubscriberObserver s : subscribers) s.update(...);  // 알림만 보내면 끝
 * }</pre>
 * <p>→ 채널은 "알림을 보낸다"까지만 책임지고, 알림을 받아서 "무엇을 할지"는 각 구독자가 정합니다.
 * (푸시를 띄우든, 이메일을 보내든, 카톡을 보내든)</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>채널이 {@code List<PushUser>}, {@code List<EmailUser>}를 따로 들고,
 * 영상을 올릴 때마다 {@code pushUser.showPush(...)}, {@code emailUser.sendMail(...)}을 각각 호출해야 합니다.</p>
 * <ul>
 *   <li>→ 카톡 알림 구독자가 생기면 채널 코드를 또 고쳐야 합니다.</li>
 *   <li>→ 발행자(채널)와 구독자가 강하게 얽혀서(강한 결합), 한쪽을 바꾸면 다른 쪽도 바꿔야 합니다.</li>
 *   <li>→ 인터페이스 하나를 사이에 두면 서로를 몰라도 되는 "느슨한 결합"이 됩니다.</li>
 * </ul>
 *
 * @see PushUserObserver
 * @see EmailUserObserver
 * @see YoutubeChannelObserver
 */
public interface SubscriberObserver {

    /**
     * 채널에서 새 영상이 올라오면 호출됩니다.
     *
     * @param channelName 영상을 올린 채널 이름
     * @param videoTitle  새 영상 제목
     */
    void update(String channelName, String videoTitle);
}
