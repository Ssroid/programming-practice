package org.sunms.designpattern.structural.adapter;

/**
 * 어댑터 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainAdapter {

    /**
     * <b>어댑터 패턴(Adapter Pattern)</b>: 서로 모양(인터페이스)이 안 맞는 두 클래스를
     * "변환기"로 연결해 주는 구조 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>한국 콘센트는 220V 플러그만 받습니다. ({@link Plug220vAdapter} 규격)
     * 그런데 미국에서 사 온 헤어드라이어는 110V 플러그입니다. ({@link AmericanHairDryerAdapter})</p>
     * <ul>
     *   <li>그대로는 꽂을 수 없음!</li>
     *   <li>그렇다고 드라이어를 뜯어고치거나(외부 라이브러리라 수정 불가),
     *       콘센트를 바꿀 수도(기존 코드 수정) 없습니다.</li>
     * </ul>
     *
     * <h4>해결 방법</h4>
     * <p>중간에 "돼지코(변환기)"를 끼운다!
     * 변환기는 겉으로는 220V 플러그 모양(Target 구현),
     * 안쪽에서는 110V 드라이어를 붙잡고(Adaptee 보관) 신호를 변환해서 전달합니다.</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Target</b>: {@link Plug220vAdapter} (클라이언트가 기대하는 규격, 인터페이스)</li>
     *   <li><b>Adaptee</b>: {@link AmericanHairDryerAdapter} (규격이 안 맞는 기존 클래스)</li>
     *   <li><b>Adapter</b>: {@link PlugConverterAdapter} (변환기, Target을 구현하고 Adaptee를 감쌈)</li>
     *   <li><b>Client</b>: {@link KoreanSocketAdapter} (Target 규격만 아는 사용자)</li>
     * </ul>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 기존 코드(드라이어, 콘센트)를 하나도 수정하지 않고 연결 가능</li>
     *   <li><b>단점</b>: 클래스가 하나 더 생김</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>{@code Arrays.asList(배열)}: 배열 → {@code List} 인터페이스로 변환</li>
     *   <li>{@code InputStreamReader}: 바이트 스트림 → 문자 스트림으로 변환</li>
     *   <li>외부 결제 API(규격이 제각각)를 우리 회사 결제 인터페이스에 맞출 때</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        KoreanSocketAdapter socket = new KoreanSocketAdapter();

        System.out.println("===== 1. 한국 선풍기 꽂기 (규격이 맞음) =====");
        socket.plugIn(new KoreanFanAdapter());

        System.out.println();
        System.out.println("===== 2. 미국 드라이어 그냥 꽂기 =====");
        AmericanHairDryerAdapter dryer = new AmericanHairDryerAdapter();
        // socket.plugIn(dryer);   // ← 주석 풀면 컴파일 에러! (드라이어는 Plug220vAdapter 가 아님)
        System.out.println("  (컴파일 에러: 규격이 안 맞아서 꽂을 수 없음)");

        System.out.println();
        System.out.println("===== 3. 돼지코 변환기를 끼워서 꽂기 =====");
        Plug220vAdapter converter = new PlugConverterAdapter(dryer);   // 드라이어를 변환기로 감쌈
        socket.plugIn(converter);                                      // 이제 꽂을 수 있음!

        /*
         * [정리]
         *   콘센트(KoreanSocketAdapter) 코드 수정: 0줄
         *   드라이어(AmericanHairDryerAdapter) 코드 수정: 0줄
         *   변환기(PlugConverterAdapter) 하나만 추가해서 해결!
         */
    }
}
