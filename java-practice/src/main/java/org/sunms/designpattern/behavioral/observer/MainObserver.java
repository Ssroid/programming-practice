package org.sunms.designpattern.behavioral.observer;

/**
 * 옵저버 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainObserver {

    /**
     * <b>옵저버 패턴(Observer Pattern)</b>: 어떤 객체의 상태가 바뀌면, 그것을 "구독"한 객체들에게
     * 자동으로 알림을 보내는 행위 패턴입니다. (발행-구독, Publish-Subscribe 모델이라고도 부름)
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>유튜브 채널에 새 영상이 올라왔는지 알고 싶을 때,
     * 구독자가 1분마다 채널에 들어가서 "새 영상 있어요?" 하고 확인한다면?<br>
     * → 대부분은 헛걸음 (자원 낭비). 이것을 "폴링(Polling)"이라고 합니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>구독자는 채널에 "구독(등록)"만 해 둡니다.
     * 채널은 새 영상을 올릴 때, 등록된 구독자 목록을 돌면서 알림을 보냅니다. (푸시)<br>
     * → 유튜브 "알림 설정"과 똑같은 원리!</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Observer</b>: {@link SubscriberObserver} ("알림을 받을 수 있다"는 규격, 인터페이스)</li>
     *   <li><b>Concrete Observer</b>: {@link PushUserObserver}, {@link EmailUserObserver} (알림을 받으면 각자 다르게 반응)</li>
     *   <li><b>Subject</b>: {@link YoutubeChannelObserver} (구독자 목록을 관리하고 알림을 보냄)</li>
     * </ul>
     *
     * <h4>핵심: 느슨한 결합</h4>
     * <p>채널은 구독자가 "앱 사용자인지, 이메일 사용자인지" 모릅니다.
     * 그저 {@link SubscriberObserver} 인터페이스의 {@code update()}만 호출할 뿐!<br>
     * → 새로운 종류의 구독자(예: 카카오톡 알림)가 생겨도 채널 코드 수정이 필요 없습니다.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 발행자와 구독자가 서로 독립적, 구독/해지를 실행 중에 자유롭게</li>
     *   <li><b>단점</b>: 알림 순서를 보장하기 어려움, 구독 해지를 잊으면 메모리 누수 가능</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>GUI 이벤트 리스너: {@code button.addActionListener(...)} (버튼 클릭을 "구독")</li>
     *   <li>스프링의 {@code ApplicationEvent} / {@code @EventListener}</li>
     *   <li>카카오톡/슬랙 알림, 주식 시세 알림, Kafka 같은 메시지 큐</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        YoutubeChannelObserver channel = new YoutubeChannelObserver("자바 배우기 채널");

        SubscriberObserver kim = new PushUserObserver("김자바");
        SubscriberObserver lee = new PushUserObserver("이스프링");
        SubscriberObserver park = new EmailUserObserver("park@example.com");

        System.out.println("===== 1. 구독하기 =====");
        channel.subscribe(kim);
        channel.subscribe(lee);
        channel.subscribe(park);

        System.out.println();
        System.out.println("===== 2. 새 영상 업로드 → 구독자 전원에게 자동 알림 =====");
        channel.uploadVideo("디자인 패턴 1강: 싱글톤");

        System.out.println();
        System.out.println("===== 3. 이스프링 구독 해지 후 업로드 =====");
        channel.unsubscribe(lee);
        channel.uploadVideo("디자인 패턴 2강: 옵저버");   // 이스프링은 알림을 못 받음

        System.out.println();
        System.out.println("===== 4. 람다로 즉석 구독자 만들기 =====");
        // SubscriberObserver 는 메서드가 1개뿐이라 람다로도 만들 수 있음
        channel.subscribe((channelName, title) ->
                System.out.println("    → [카톡 알림] " + channelName + " 에 '" + title + "' 이(가) 올라왔어요!"));
        channel.uploadVideo("디자인 패턴 3강: 전략");
    }
}
