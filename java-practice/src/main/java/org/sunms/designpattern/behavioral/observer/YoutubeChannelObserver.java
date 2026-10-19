package org.sunms.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 유튜브 채널입니다. 구독자 목록을 들고 있다가, 영상이 올라오면 모두에게 알립니다.
 *
 * <p><b>역할:</b> Subject (주제, 발행자)</p>
 *
 * <h2>꼭 필요한 3가지 메서드</h2>
 * <ol>
 *   <li>{@link #subscribe(SubscriberObserver)}: 구독자 등록</li>
 *   <li>{@link #unsubscribe(SubscriberObserver)}: 구독자 해지</li>
 *   <li>{@link #notifySubscribers(String)}: 등록된 구독자 전원에게 알림</li>
 * </ol>
 *
 * @see SubscriberObserver
 */
public class YoutubeChannelObserver {

    /** 채널 이름 */
    private final String channelName;

    /** 구독자 목록. 타입이 "인터페이스"라서 어떤 종류의 구독자든 담을 수 있습니다. */
    private final List<SubscriberObserver> subscribers = new ArrayList<>();

    /**
     * 채널을 만듭니다.
     *
     * @param channelName 채널 이름
     */
    public YoutubeChannelObserver(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 구독자를 등록합니다.
     *
     * @param subscriber 등록할 구독자
     */
    public void subscribe(SubscriberObserver subscriber) {
        subscribers.add(subscriber);
        System.out.println("  [" + channelName + "] 구독자 +1 (현재 " + subscribers.size() + "명)");
    }

    /**
     * 구독을 해지합니다. 해지한 구독자는 더 이상 알림을 받지 않습니다.
     *
     * @param subscriber 해지할 구독자
     */
    public void unsubscribe(SubscriberObserver subscriber) {
        subscribers.remove(subscriber);
        System.out.println("  [" + channelName + "] 구독자 -1 (현재 " + subscribers.size() + "명)");
    }

    /**
     * 새 영상을 업로드합니다. (상태 변화 발생 → 구독자에게 알림)
     *
     * @param videoTitle 영상 제목
     */
    public void uploadVideo(String videoTitle) {
        System.out.println("  [" + channelName + "] 새 영상 업로드: \"" + videoTitle + "\"");
        notifySubscribers(videoTitle);
    }

    /**
     * 등록된 구독자 전원에게 알림을 보냅니다.
     * 각자 알아서 반응하도록 알림만 보냅니다.
     *
     * @param videoTitle 새 영상 제목
     */
    private void notifySubscribers(String videoTitle) {
        for (SubscriberObserver subscriber : subscribers) {
            subscriber.update(channelName, videoTitle);
        }
    }
}
